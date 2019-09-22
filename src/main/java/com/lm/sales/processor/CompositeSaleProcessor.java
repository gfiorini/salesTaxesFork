package com.lm.sales.processor;

import com.lm.sales.model.Amount;
import com.lm.sales.model.CartItem;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class CompositeSaleProcessor implements ISaleProcessor {

    private List<ISaleProcessor> processors;

    public CompositeSaleProcessor(){
        processors = new ArrayList<>();
    }

    public CompositeSaleProcessor(List<ISaleProcessor> processors) {
        this.processors = processors;
    }

    public void add(ISaleProcessor processor){
        this.processors.add(processor);
    }

    @Override
    public Amount calculate(CartItem cartItem) {
        Amount taxes = new Amount(BigDecimal.ZERO, cartItem.getPrice().getIsoCurrencyCode());
        for (ISaleProcessor saleProcessor: processors){
            taxes = taxes.add(saleProcessor.calculate(cartItem));
        }
        return taxes;
    }
}
