package com.lm.sales.manager.receipt;

import com.lm.sales.manager.receipt.BaseReceiptManager;
import com.lm.sales.manager.tax.ITaxManager;
import com.lm.sales.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component("IT")
public class ReceiptManagerITA extends BaseReceiptManager {

    @Autowired
    @Qualifier("taxManagerITA")
    private ITaxManager taxManager;

    public ITaxManager getTaxManager() {
        return taxManager;
    }

    public void setTaxManager(ITaxManager taxManager) {
        this.taxManager = taxManager;
    }
}
