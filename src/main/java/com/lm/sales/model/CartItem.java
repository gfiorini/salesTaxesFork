package com.lm.sales.model;

public class CartItem {

    private Item instance;

    private Amount amount;

    private long quantity = 0;

    private boolean flgImported;

    public CartItem(Item instance) {
        this(instance, 1);
    }

    public CartItem(Item instance, long quantity) {
        this(instance, quantity, false);
    }

    public CartItem(Item instance, long quantity, boolean flgImported) {
        this.instance = instance;
        this.quantity = quantity;
        this.flgImported = true;
    }

    public void add(long quantity){
        this.quantity += quantity;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public Item getInstance() {
        return instance;
    }

    public void setInstance(Item instance) {
        this.instance = instance;
    }
}
