package com.lm.sales.processor;

import com.lm.sales.helper.ITaxRounder;
import com.lm.sales.model.Amount;
import com.lm.sales.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("basicSaleProcessor")
public class BasicSaleProcessor extends AbstractSaleProcessor {

    private BigDecimal taxRate = new BigDecimal("0.1");

    @Override
    public Amount calculate(CartItem cartItem) {
        Amount taxes = cartItem.getTotalNetPrice().multiply(taxRate);
        return rounder.round(taxes);
    }
}
