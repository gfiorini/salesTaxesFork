package com.lm.sales.controller;

import com.lm.sales.factory.IReceiptManagerFactory;
import com.lm.sales.manager.IReceiptManager;
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
    private IReceiptManagerFactory receiptManagerFactory;

    @RequestMapping("/receipt")
    public Receipt dummy() {
        IReceiptManager IReceiptManager = receiptManagerFactory.build("dummy");
        Receipt receipt = IReceiptManager.calculateReceipt(null);
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
