package com.lm.sales.manager.tax;

import com.lm.sales.model.Amount;
import com.lm.sales.model.CartItem;
import org.springframework.stereotype.Component;

@Component
public interface ITaxManager {

    Amount applyTaxes(CartItem ci);

}
