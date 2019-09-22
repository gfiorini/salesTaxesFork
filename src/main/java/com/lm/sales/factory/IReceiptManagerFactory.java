package com.lm.sales.factory;

import com.lm.sales.manager.receipt.IReceiptManager;
import org.springframework.stereotype.Component;

@Component
public interface IReceiptManagerFactory {

    IReceiptManager build(String countryCode);
}
