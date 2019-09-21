package com.lm.sales.model;

import java.math.BigDecimal;
import java.util.List;

public class Receipt {

    private List<ReceiptItem> items;

    private Amount rawTotal = new Amount(BigDecimal.ZERO);

    private Amount saleTaxes = new Amount(BigDecimal.ZERO);

    private Amount total = new Amount(BigDecimal.ZERO);

    public Receipt(List<ReceiptItem> items) {
        this.items = items;
    }

    public List<ReceiptItem> getItems() {
        return items;
    }

    public void setItems(List<ReceiptItem> items) {
        this.items = items;
    }

    public void calculateTotals(){
        for (ReceiptItem r: items){
            rawTotal.add(r.getTaxes());
        }
    }


}
