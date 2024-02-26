package io.demo.apis.digisicapis;

import org.apache.logging.log4j.LogManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banking")
public class DemoPagoController {

    private static final org.apache.logging.log4j.Logger log4jLogger = LogManager.getLogger("log4j-logger");

    @RequestMapping(value = "/pago", method = RequestMethod.GET)
	@ResponseBody
    public String teste(@RequestParam(name="total",required = true) String totalPago,@RequestParam(name="customerId",required = true) String customerId){
        System.out.println(totalPago);

        log4jLogger.info("Receiving pago for:",customerId);

        processPayment(totalPago,customerId);

        return "{'transactionId':'kadsbflajkhdfas','status':'OK'}";
    }

    private void processPayment(String pagoTotal,String pagoCustomerId){
        log4jLogger.info("Processing pago for:",pagoCustomerId);
        updateCustomerBalance(pagoTotal,pagoCustomerId);
        updateDB();
    }

    private void updateCustomerBalance(String pagoTotal,String pagoCustomerId){
        log4jLogger.info("Update balance for:",pagoCustomerId);
        System.out.println("updateCustomerBalance");
    }

    private void updateDB(){
        log4jLogger.info("Update BD");
        System.out.println("updateDB");
    }
    
}
