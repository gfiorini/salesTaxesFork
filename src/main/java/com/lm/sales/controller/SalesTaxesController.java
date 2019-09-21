package com.lm.sales.controller;

import com.lm.sales.factory.IReceiptManagerFactory;
import com.lm.sales.manager.IReceiptManager;
import com.lm.sales.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan({"com.lm.sales"})
public class SalesTaxesController {

    @Autowired
    private IReceiptManagerFactory receiptManagerFactory;

    @RequestMapping("/calculateReceipt")
    public Receipt calculate(@RequestBody(required = true) Cart cart, @RequestParam(value = "country", required = false, defaultValue = "IT") String countryCode) {
        IReceiptManager IReceiptManager = receiptManagerFactory.build(countryCode);
        Receipt receipt = IReceiptManager.calculateReceipt(cart);
        return receipt;
    }

    public static void main(String[] args) {
        SpringApplication.run(SalesTaxesController.class, args);
    }


}
