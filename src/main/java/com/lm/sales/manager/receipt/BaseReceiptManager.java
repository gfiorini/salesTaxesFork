package com.lm.sales.manager.receipt;

import com.lm.sales.manager.tax.ITaxManager;
import com.lm.sales.model.Amount;
import com.lm.sales.model.CartItem;
import com.lm.sales.model.ReceiptItem;

public abstract class BaseReceiptManager implements IReceiptManager {

    protected ReceiptItem buildReceiptItem(CartItem ci, ITaxManager taxManager) {
        Amount taxes = taxManager.applyTaxes(ci);
        ReceiptItem receiptItem = new ReceiptItem(ci, taxes);
        return receiptItem;
    }

}
