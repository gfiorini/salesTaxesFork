package com.lm.sales.manager.receipt;

import com.lm.sales.manager.receipt.BaseReceiptManager;
import com.lm.sales.manager.tax.ITaxManager;
import com.lm.sales.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component("IT")
public class ReceiptManagerITA extends BaseReceiptManager {

    @Autowired
    private ITaxManager taxManager;

    @Override
    public Receipt calculateReceipt(Cart cart) {

        List<ReceiptItem> receiptItems = new ArrayList<>();

        Collection<CartItem> cartItems = cart.getItems().values();
        for(CartItem ci: cartItems){
            ReceiptItem receiptItem = buildReceiptItem(ci, taxManager);
            receiptItems.add(receiptItem);
        }

        Receipt receipt = new Receipt(receiptItems);
        return receipt;

    }

    public ITaxManager getTaxManager() {
        return taxManager;
    }

    public void setTaxManager(ITaxManager taxManager) {
        this.taxManager = taxManager;
    }
}
