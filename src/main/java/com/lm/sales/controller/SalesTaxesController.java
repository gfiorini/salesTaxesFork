package com.lm.sales.controller;

import com.lm.sales.model.Cart;
import com.lm.sales.model.Receipt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class SalesTaxesController {


    @RequestMapping("/calculate")
    public Receipt calculate(@RequestBody(required = true) Cart cart, @RequestParam(value = "country", required = false, defaultValue = "IT") String countryCode) {
        return new Receipt();
    }

    public static void main(String[] args) {
        SpringApplication.run(SalesTaxesController.class, args);
    }


}
