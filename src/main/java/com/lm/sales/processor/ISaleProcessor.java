package com.lm.sales.processor;

import com.lm.sales.model.Amount;
import com.lm.sales.model.CartItem;
import org.springframework.stereotype.Component;

@Component
public interface ISaleProcessor {

    public Amount calculate(CartItem cartItem);

}
