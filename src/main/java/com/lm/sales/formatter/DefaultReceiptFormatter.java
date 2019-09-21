package com.lm.sales.formatter;

import com.lm.sales.model.Receipt;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("defaultReceiptFormatter")
public class DefaultReceiptFormatter implements IReceiptFormatter {

    @Override
    public List<String> print(Receipt receipt) {

        List<String> lines = new ArrayList<>();
        receipt.calculateTotals();

        return lines;
    }
}
