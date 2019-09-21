package com.lm.sales.formatter;

import com.lm.sales.model.Receipt;

public class DefaultReceiptFormatter implements ReceiptFormatter {

    @Override
    public String print(Receipt receipt) {
        receipt.calculateTotals();

        StringBuilder sb = new StringBuilder();

        return sb.toString();
    }
}
