package com.lm.sales.formatter;

import com.lm.sales.model.Receipt;
import com.lm.sales.model.ReceiptItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("defaultReceiptFormatter")
public class DefaultReceiptFormatter implements IReceiptFormatter {

    @Override
    public List<String> print(Receipt receipt) {

        List<String> lines = new ArrayList<>();

        List<ReceiptItem> items = receipt.getItems();
        for (ReceiptItem r: items){
            StringBuilder sb = new StringBuilder();
            sb.append(r.getCartItem().getQuantity()).append(" ")
              .append(r.getCartItem().getInstance().getDescription()).append(": ")
              .append(r.getTotalPrice().getValue());
            lines.add(sb.toString());
        }
        lines.add(new StringBuilder("Sales Taxes: ").append(receipt.getSalesTaxes().getValue()).toString());
        lines.add(new StringBuilder("Total: ").append(receipt.getTotal().getValue()).toString());

        return lines;
    }
}
