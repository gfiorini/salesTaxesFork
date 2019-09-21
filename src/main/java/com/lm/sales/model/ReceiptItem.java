package com.lm.sales.model;

public class ReceiptItem {

    private CartItem cartItem;

    private Amount taxes;

    public ReceiptItem(CartItem cartItem, Amount taxes) {
        this.cartItem = cartItem;
        this.taxes = taxes;
    }

    public CartItem getCartItem() {
        return cartItem;
    }

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
    }

    public Amount getTaxes() {
        return taxes;
    }

    public void setTaxes(Amount taxes) {
        this.taxes = taxes;
    }
}
