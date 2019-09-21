package com.lm.sales.factory;

import com.lm.sales.manager.IReceiptManager;
import org.springframework.stereotype.Component;

@Component
public interface IReceiptManagerFactory {

    IReceiptManager build(String countryCode);
}
