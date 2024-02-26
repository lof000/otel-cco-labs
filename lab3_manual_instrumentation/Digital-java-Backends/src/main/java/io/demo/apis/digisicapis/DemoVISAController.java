package io.demo.apis.digisicapis;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/visadirect")
public class DemoVISAController {

    @Value("${AWS_API_URL:NONE}")
    private String awsLambdaUrl;

    @Value("${SLOW_REGION:NONE}")
    private String slowRegion;

    @Value("${SLOW_TIME:NONE}")
    private String slowTime;

    //http://httpvisadirect10418-8080-default.mock.blazemeter.com/visadirect/fundstransfer/v1/pullfundstransactions?idcode=ABCD1234ABCD123&amount=5

    @RequestMapping(value = "/fundstransfer/v1/pullfundstransactions", method = RequestMethod.GET)
	@ResponseBody
    public String atmSearch(@RequestParam(name="idcode",required = false) String idcode,@RequestParam(name="amount",required = false) String amount){
        System.out.println(idcode);
        System.out.println(amount);

        if (idcode.equals("aws")){
            System.out.println("Calling AWS");
            if (!awsLambdaUrl.equals("NONE")){
                RestTemplate restTemplate = new RestTemplate();
                ResponseEntity<String> response  = restTemplate.getForEntity(awsLambdaUrl, String.class);
                System.out.println(response.getBody());
            }else{
                System.out.println("NO Url");
            }

        }

        if (!slowRegion.equals("NONE")){
            if (idcode.equalsIgnoreCase(slowRegion)){
                if (slowTime.equals("NONE")){
                    slowTime="3000";
                }
                try {
                    System.out.println("hanging for "+slowTime+" ms");
                    Thread.sleep(Long.parseLong(slowTime));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


        return "{\"transactionIdentifier\": 875806056061895, \"actionCode\": \"00\", \"approvalCode\": \"98765X\", \"responseCode\": \"5\", \"transmissionDateTime\": \"2020-08-28T11:52:08Z\", \"cavvResultCode\": \"8\", \"cpsAuthorizationCharacteristicsIndicator\": \"3333\"}";
    }


    @RequestMapping(value = "/pix", method = RequestMethod.POST)
	@ResponseBody
    public String teste(@RequestBody String jsonExemplo){
        System.out.println(jsonExemplo);
        return jsonExemplo;
    }

}