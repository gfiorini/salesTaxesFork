package com.lm.sales.formatter;

import com.lm.sales.model.Receipt;

import java.util.List;

public interface IReceiptFormatter {

    public List<String> print(Receipt receipt);

}
