package com.lm.sales.controller;

import com.lm.sales.factory.ReceiptManagerFactory;
import com.lm.sales.manager.ReceiptManager;
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

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan({"com.lm.sales"})
public class SalesTaxesController {

    @Autowired
    private ReceiptManagerFactory receiptManagerFactory;

    @RequestMapping("/calculateReceipt")
    public Receipt calculate(@RequestBody(required = true) Cart cart, @RequestParam(value = "country", required = false, defaultValue = "IT") String countryCode) {
        ReceiptManager receiptManager = receiptManagerFactory.build(countryCode);
        Receipt receipt = receiptManager.calculateReceipt(cart);
        return receipt;
    }

    public static void main(String[] args) {
        SpringApplication.run(SalesTaxesController.class, args);
    }


}
