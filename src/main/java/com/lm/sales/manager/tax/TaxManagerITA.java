package com.lm.sales.manager.tax;

import com.lm.sales.model.CartItem;
import com.lm.sales.processor.CompositeSaleProcessor;
import com.lm.sales.processor.ISaleProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TaxManagerITA extends AbstractTaxManager {

    public static final Set<String> noTaxesSetBasicSaleCategories =
            new HashSet<>(Arrays.asList(new String[] { "BOOK", "FOOD", "MEDICAL" }));

    @Autowired
    @Qualifier("basicSaleProcessor")
    private ISaleProcessor basicSaleProcessor;

    @Autowired
    @Qualifier("importedSaleProcessor")
    private ISaleProcessor importedSaleProcessor;

    @Override
    protected ISaleProcessor getTaxProcessor(CartItem ci) {
        CompositeSaleProcessor csp = new CompositeSaleProcessor();

        if (!noTaxesSetBasicSaleCategories.contains(ci.getInstance().getCategory().getCode())){
            csp.add(basicSaleProcessor);
        }

        if (ci.isFlgImported()){
            csp.add(importedSaleProcessor);
        }

        return csp;
    }
}
