package com.lm.sales.util;

import com.lm.sales.model.Item;
import org.springframework.stereotype.Component;

@Component
public interface KeyGenerator {

    String buildKey(Item item, boolean flgImported);

}
