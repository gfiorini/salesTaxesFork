package com.lm.sales.factory;

import com.lm.sales.manager.ReceiptManager;
import org.springframework.stereotype.Component;

@Component
public interface ReceiptManagerFactory {

    ReceiptManager build(String countryCode);
}
