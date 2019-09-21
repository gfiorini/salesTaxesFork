package com.lm.sales.factory;

import com.lm.sales.manager.ReceiptManager;
import com.lm.sales.manager.ReceiptManagerDummy;
import com.lm.sales.manager.ReceiptManagerITA;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("defaultReceiptManagerFactory")
public class DefaultReceiptManagerFactory implements ReceiptManagerFactory {


    /* simple factory to handle different taxes for different countries, for simplicity will be implemented only "IT" taxation (default)  */
    @Override
    public ReceiptManager build(String countryCode) {
        if ("IT".equalsIgnoreCase(countryCode)){
            return new ReceiptManagerITA();
        } else if ("dummy".equalsIgnoreCase(countryCode)){
            return new ReceiptManagerDummy();
        } else {
            throw new UnsupportedOperationException();
        }
    }


}
