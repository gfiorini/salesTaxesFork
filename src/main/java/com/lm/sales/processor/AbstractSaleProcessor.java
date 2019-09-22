package com.lm.sales.processor;

import com.lm.sales.helper.ITaxRounder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractSaleProcessor implements ISaleProcessor {

    @Autowired
    protected ITaxRounder rounder;

}
