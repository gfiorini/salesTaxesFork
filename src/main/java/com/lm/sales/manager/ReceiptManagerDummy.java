package com.lm.sales.manager;

import com.lm.sales.model.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component("receiptManagerDummy")
public class ReceiptManagerDummy implements ReceiptManager {

    @Override
    public Receipt calculateReceipt(Cart cart) {
        List<ReceiptItem> items = new ArrayList<ReceiptItem>();
        Item item = new Item(new Long(1), "XY123", "test product", new Category("TST"));
        CartItem ci = new CartItem(item, new Amount(new BigDecimal("1000")), true);
        ReceiptItem dummyItem = new ReceiptItem(ci, new Amount(new BigDecimal("49")));
        items.add(dummyItem);
        return new Receipt(items);
    }
}
