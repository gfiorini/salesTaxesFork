package com.lm.sales.model;

public class CartItem {

    private Item instance;

    private Amount price;

    private long quantity = 0;

    private boolean flgImported;

    public CartItem(Item instance, Amount price, boolean flgImported) {
        this(instance, price, flgImported, 1);
    }

    public CartItem(Item instance, Amount price, boolean flgImported, long quantity) {
        this.instance = instance;
        this.price = price;
        this.flgImported = flgImported;
        this.quantity = quantity;
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

    public Amount getPrice() {
        return price;
    }

    public void setPrice(Amount price) {
        this.price = price;
    }

    public boolean isFlgImported() {
        return flgImported;
    }

    public void setFlgImported(boolean flgImported) {
        this.flgImported = flgImported;
    }
}
