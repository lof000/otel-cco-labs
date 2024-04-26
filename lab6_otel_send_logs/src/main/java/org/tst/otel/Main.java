package org.tst.otel;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;

import io.opentelemetry.proto.logs.v1.SeverityNumber;

public class Main {
    public static void main(String[] args) throws ClientProtocolException, IOException {

        System.out.println("Sending logs...");

        Platform p = new Platform();
        p.configure("host", "tenant", "clientId", "clientSecret");

        p.sendOtelLog("aaahhhh", SeverityNumber.SEVERITY_NUMBER_DEBUG, getAttr());

    }

    
    private static Map<String,String> getAttr(){

        Map<String,String> m = new HashMap<String,String>();
        m.put("device","android" );

        return m;

    }


}