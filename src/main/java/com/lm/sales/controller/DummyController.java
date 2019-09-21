package com.lm.sales.controller;

import com.lm.sales.factory.ReceiptManagerFactory;
import com.lm.sales.manager.ReceiptManager;
import com.lm.sales.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DummyController {

    @Autowired
    private ReceiptManagerFactory receiptManagerFactory;

    @RequestMapping("/receipt")
    public Receipt dummy() {
        ReceiptManager receiptManager = receiptManagerFactory.build("dummy");
        Receipt receipt = receiptManager.calculateReceipt(null);
        return receipt;
    }

    @RequestMapping("/cart")
    public Cart cart() {
        Map<String, CartItem> items = new HashMap<>();
        Cart c = new Cart();
        Item item = new Item(new Long(1), "XY123", "test product", new Category("TST"));
        c.addItem(item, new Amount(new BigDecimal("1000")));
        return c;
    }
}
