package com.lm.sales.util;

import com.lm.sales.model.Item;
import org.springframework.stereotype.Component;

@Component
public class DefaultKeyGenerator implements KeyGenerator {

    @Override
    public String buildKey(Item item, boolean flgImported) {
        return new StringBuilder().append(item.getProductCode()).append("_").append(flgImported).toString();
    }
}
