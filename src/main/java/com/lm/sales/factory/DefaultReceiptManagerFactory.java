package com.lm.sales.factory;

import com.lm.sales.manager.IReceiptManager;
import com.lm.sales.manager.ReceiptManagerDummy;
import com.lm.sales.manager.ReceiptManagerITA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DefaultReceiptManagerFactory implements IReceiptManagerFactory {

    @Autowired
    private Map<String, IReceiptManager> map;

    @Override
    public IReceiptManager build(String countryCode) {
        IReceiptManager rm = map.get(countryCode);
        if (rm == null){
            throw new UnsupportedOperationException("unsupported country: " + countryCode);
        } else {
            return rm;
        }
    }


}
