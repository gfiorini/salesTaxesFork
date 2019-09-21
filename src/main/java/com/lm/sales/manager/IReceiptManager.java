package com.lm.sales.manager;

import com.lm.sales.model.Cart;
import com.lm.sales.model.Receipt;

public interface IReceiptManager {

    Receipt calculateReceipt(Cart cart);
}
