package com.lm.sales.helper;

import com.lm.sales.model.Amount;
import org.springframework.stereotype.Component;

@Component
public interface ITaxRounder {

    public Amount round(Amount value);
}
