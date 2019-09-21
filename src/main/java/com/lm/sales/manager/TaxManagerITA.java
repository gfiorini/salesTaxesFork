package com.lm.sales.manager;

import com.lm.sales.model.Amount;
import com.lm.sales.model.CartItem;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TaxManagerITA implements ITaxManager {

    @Override
    public Amount applyTaxes(CartItem ci) {
        return new Amount(new BigDecimal("999"));
    }

}
