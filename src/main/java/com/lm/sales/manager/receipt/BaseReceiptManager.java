package com.lm.sales.manager.receipt;

import com.lm.sales.manager.tax.ITaxManager;
import com.lm.sales.model.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class BaseReceiptManager implements IReceiptManager {

    @Override
    public Receipt calculateReceipt(Cart cart) {

        List<ReceiptItem> receiptItems = new ArrayList<>();

        Collection<CartItem> cartItems = cart.getItems().values();
        for(CartItem ci: cartItems){
            ReceiptItem receiptItem = buildReceiptItem(ci, getTaxManager());
            receiptItems.add(receiptItem);
        }

        Receipt receipt = new Receipt(receiptItems);
        return receipt;

    }

    protected ReceiptItem buildReceiptItem(CartItem ci, ITaxManager taxManager) {
        Amount taxes = taxManager.applyTaxes(ci);
        ReceiptItem receiptItem = new ReceiptItem(ci, taxes);
        return receiptItem;
    }

    protected abstract ITaxManager getTaxManager();

}
