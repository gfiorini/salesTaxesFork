package com.lm.sales.helper;

import com.lm.sales.model.Amount;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class DefaultTaxRounder implements ITaxRounder {

    @Override
    public Amount round(Amount amount) {
        return new Amount(amount.getValue().setScale(2, BigDecimal.ROUND_HALF_UP), amount.getIsoCurrencyCode());
    }
}
