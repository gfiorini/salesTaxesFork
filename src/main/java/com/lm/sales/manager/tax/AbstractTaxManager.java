package com.lm.sales.manager.tax;

import com.lm.sales.model.Amount;
import com.lm.sales.model.CartItem;
import com.lm.sales.processor.ISaleProcessor;

public abstract class AbstractTaxManager implements ITaxManager {

    @Override
    public Amount applyTaxes(CartItem ci) {
        ISaleProcessor tp = getTaxProcessor(ci);
        return tp.calculate(ci);
    }

    protected abstract ISaleProcessor getTaxProcessor(CartItem ci);
}
