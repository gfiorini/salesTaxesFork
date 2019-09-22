package com.lm.sales.helper;

import com.lm.sales.model.Amount;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Component
public class DefaultTaxRounder implements ITaxRounder {

    @Override
    public Amount round(Amount amount) {
        BigDecimal twenty = new BigDecimal("20");
        BigDecimal value = amount.getValue();
        value = value.multiply(twenty).round(new MathContext(2, RoundingMode.UP)).divide(twenty).setScale(2);
        return new Amount(value, amount.getIsoCurrencyCode());
    }
}
