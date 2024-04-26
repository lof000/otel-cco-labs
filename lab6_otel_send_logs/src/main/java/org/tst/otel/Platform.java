package org.tst.otel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;


import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import io.opentelemetry.proto.collector.logs.v1.ExportLogsServiceRequest;
import io.opentelemetry.proto.common.v1.AnyValue;
import io.opentelemetry.proto.common.v1.KeyValue;
import io.opentelemetry.proto.logs.v1.LogRecord;
import io.opentelemetry.proto.logs.v1.ResourceLogs;
import io.opentelemetry.proto.logs.v1.ScopeLogs;
import io.opentelemetry.proto.logs.v1.SeverityNumber;
import io.opentelemetry.proto.resource.v1.Resource;

/**
 * Classe Platform
 * 
 * Encapsula o envio de logs no formato OTEL para a Cisco Observability Platform
 * 
 * Disclaimer:
 * 
 * Prova de Conceito - antes de usar em prod mais fatores devem ser levados em consideração como por exemplo, envio em batch, tratamento do token quel ele expira e etc.
 * 
 * @
 * @author VO
 *
 */
public class Platform {

    private final HttpClient httpClient = HttpClients.createDefault();
    private String endpoint;
    private Map<String,String> resourceAttribs;

    //access config
    private String host;
    private String tenant;
    private String clientId;
    private String clientSecret;


    /**
     * Método configure
     * 
     * Deve ser o primeiro método a ser chamado depois de instancia a classe
     * 
     * @param host - dominio.observe.appdynamics.com
     * @param tenant - voce obtem na plataforma
     * @param clientId - obtem quando voce tem um agent principal
     * @param clientSecret - obtem quando voce tem um agent principal
     */
    public void configure(String host,String tenant,String clientId,String clientSecret){
        this.host = host;
        this.tenant = tenant;
        this.clientId = clientId;
        this.clientSecret = clientSecret;

        this.endpoint = buildEndpoint(this.host);

        resourceAttribs = configResourceAttribs();
    }

    private String getAccessToken() {
        try {

            // Encode username and password for basic authentication
            String authString = clientId + ":" + clientSecret;
            String encodedAuthString = Base64.getEncoder().encodeToString(authString.getBytes());

            // Create HTTP connection
            URL apiUrl = new URL(Platform.buildUrl(host, tenant));
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Basic " + encodedAuthString);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setDoOutput(true);

            // Form the request body
            String requestBody = "grant_type=client_credentials";

            // Send request
            connection.getOutputStream().write(requestBody.getBytes());

            // Get response
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Parse JSON response
                JSONObject jsonResponse = new JSONObject(response.toString());
                String accessToken = jsonResponse.getString("access_token");
                return accessToken;
            } else {
                System.out.println("Failed to retrieve access token. Response code: " + responseCode);
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
        /**
     * Método configure
     * 
     * Deve ser o primeiro método a ser chamado depois de instancia a classe
     * 
     * @param message - a mensagem de log (raw message)
     * @param severityNumber severidade
     * @param logAttributes MAP chave,valor com os atributos do log
     */
    public void sendOtelLog(String message,SeverityNumber severityNumber,Map<String,String> logAttributes ) throws ClientProtocolException, IOException{
        
        //first get the token
        String token = getAccessToken();

        //configure ResourceAttributes
        Resource res = buildResource();

        //Build logRecord
        logAttributes.put("level",translateSev(severityNumber).toLowerCase() );
        logAttributes.put("severity",translateSev(severityNumber) );
        LogRecord lgoRec = buildLogRecord(severityNumber,message,logAttributes);

        //Build the request
        ExportLogsServiceRequest req = buildLogServiceRequest(res,lgoRec);

        //Send logs
        setLogToPlatform(req,token);

    }

    private void setLogToPlatform(ExportLogsServiceRequest req,String token) throws IOException, ClientProtocolException {
        byte[] vai = req.toByteArray();
        HttpPost post = new HttpPost(endpoint);
        post.setEntity(new ByteArrayEntity(vai));
        post.setHeader("Content-Type", "application/x-protobuf");
        post.setHeader("Authorization","Bearer "+token);
        HttpResponse response = httpClient.execute(post);
        System.out.println("Sent log. Response: " + response.getStatusLine());
        EntityUtils.consume(response.getEntity());
    }

    private ExportLogsServiceRequest buildLogServiceRequest(Resource r1, LogRecord logRecord) {
        ResourceLogs rl = ResourceLogs.newBuilder()
        .setResource(r1)
        .addScopeLogs(ScopeLogs.newBuilder()
            .addLogRecords(logRecord)
            .setSchemaUrl("")
            .build())
        .build();


        ExportLogsServiceRequest req = ExportLogsServiceRequest.newBuilder()
        .addResourceLogs(rl)
        .build();
        return req;
    }

    private Resource buildResource(){

        Resource.Builder rb = Resource.newBuilder();
        int i=0;
        for (Map.Entry<String, String> entry : resourceAttribs.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            rb.addAttributes(i++,KeyValue.newBuilder().setKey(key).setValue(AnyValue.newBuilder().setStringValue(value).build()).build());
        }
        return rb.build();

    }

    private LogRecord buildLogRecord(SeverityNumber severityNumber,String body,Map<String,String> logAttribs){
            LogRecord.Builder logBuilder = LogRecord.newBuilder();
            logBuilder.setTimeUnixNano(getEpochInNanos());
            logBuilder.setObservedTimeUnixNano(getEpochInNanos());
            logBuilder.setSeverityNumber(severityNumber);
            logBuilder.setSeverityText(translateSev(severityNumber));
            logBuilder.setBody(AnyValue.newBuilder().setStringValue(body).build());

            for (Map.Entry<String, String> entry : logAttribs.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                logBuilder.addAttributes(KeyValue.newBuilder().setKey(key).setValue(AnyValue.newBuilder().setStringValue(value).build()).build());
            }

            LogRecord logRecord = logBuilder.build();
            return logRecord;
    }

    private static String buildUrl(String host,String tenant ){
        StringBuffer sb = new StringBuffer();
        sb.append("https://");
        sb.append(host);
        sb.append("/auth/");
        sb.append(tenant);
        sb.append("/default/oauth2/token");
        return sb.toString();
    }

    private static String buildEndpoint(String host){
        StringBuffer sb = new StringBuffer();
        sb.append("https://");
        sb.append(host);
        sb.append("/data/v1/logs");
        return sb.toString();
    }

    private long getEpochInNanos(){
        long currentTimeMillis = System.currentTimeMillis();
        long nanoTime = System.nanoTime();
        long currentTimeNanos = currentTimeMillis * 1_000_000;
        long baseNanoTime = System.nanoTime();
        long epochTimeNanos = currentTimeNanos + (nanoTime - baseNanoTime);
        return epochTimeNanos;
    }

    private  Map<String,String> configResourceAttribs(){
        Map<String,String> resourceAttribs = new HashMap<String,String>();
        resourceAttribs.put("telemetry.sdk.name", "opentelemetry");
        resourceAttribs.put("telemetry.sdk.version", "1.34.1");
        resourceAttribs.put("telemetry.distro.name", "opentelemetry-java-instrumentation");
        resourceAttribs.put("telemetry.distro.version", "2.0.0");
        resourceAttribs.put("telemetry.sdk.language", "java");
        resourceAttribs.put("service.name", "servicoTeste");
        resourceAttribs.put("service.namespace", "testevo");
        return resourceAttribs;

    }

    private String translateSev(SeverityNumber sevN){
        String sev = "INFO";
        switch (sevN) {
            case SEVERITY_NUMBER_DEBUG,SEVERITY_NUMBER_DEBUG2,SEVERITY_NUMBER_DEBUG3,SEVERITY_NUMBER_DEBUG4:
                sev = "DEBUG";
                break;
            case SEVERITY_NUMBER_ERROR,SEVERITY_NUMBER_ERROR2,SEVERITY_NUMBER_ERROR3,SEVERITY_NUMBER_ERROR4:
                sev = "ERROR";
                break;
            case SEVERITY_NUMBER_FATAL,SEVERITY_NUMBER_FATAL2,SEVERITY_NUMBER_FATAL3,SEVERITY_NUMBER_FATAL4:
                sev = "FATAL";
                break;
            default:
                break;
        }
        
        return sev;

    }

}



