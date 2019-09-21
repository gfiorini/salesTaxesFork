package com.lm.sales.manager;

import com.lm.sales.model.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component("receiptManagerITA")
public class ReceiptManagerITA implements ReceiptManager {

    @Override
    public Receipt calculateReceipt(Cart cart) {
        throw new UnsupportedOperationException();
    }
}
