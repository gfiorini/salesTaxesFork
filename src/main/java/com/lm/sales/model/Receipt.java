package com.lm.sales.model;

import java.math.BigDecimal;
import java.util.List;

public class Receipt {

    private List<ReceiptItem> items;

    private Amount netTotal = new Amount(BigDecimal.ZERO);

    private Amount salesTaxes = new Amount(BigDecimal.ZERO);

    private Amount total = new Amount(BigDecimal.ZERO);

    public Receipt(List<ReceiptItem> items) {
        this.items = items;
        calculateTotals();
    }

    private void calculateTotals(){
        for (ReceiptItem r: items){

            Amount itemTotalNetPrice = r.getCartItem().getTotalNetPrice();
            netTotal = netTotal.add(itemTotalNetPrice);

            Amount itemTotalTaxes = r.getTotalTaxes();
            salesTaxes = salesTaxes.add(itemTotalTaxes);

            total = total.add(itemTotalNetPrice).add(itemTotalTaxes);
        }
    }

    public List<ReceiptItem> getItems() {
        return items;
    }

    public void setItems(List<ReceiptItem> items) {
        this.items = items;
    }

    public Amount getNetTotal() {
        return netTotal;
    }

    public void setNetTotal(Amount netTotal) {
        this.netTotal = netTotal;
    }

    public Amount getSalesTaxes() {
        return salesTaxes;
    }

    public void setSalesTaxes(Amount salesTaxes) {
        this.salesTaxes = salesTaxes;
    }

    public Amount getTotal() {
        return total;
    }

    public void setTotal(Amount total) {
        this.total = total;
    }
}
