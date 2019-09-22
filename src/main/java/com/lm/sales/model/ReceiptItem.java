package com.lm.sales.model;

public class ReceiptItem {

    private CartItem cartItem;

    private Amount totalTaxes;

    public ReceiptItem(CartItem cartItem, Amount totalTaxes) {
        this.cartItem = cartItem;
        this.totalTaxes = totalTaxes;
    }

    public CartItem getCartItem() {
        return cartItem;
    }

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
    }

    public Amount getTotalTaxes() {
        return totalTaxes;
    }

    public void setTotalTaxes(Amount totalTaxes) {
        this.totalTaxes = totalTaxes;
    }

    public Amount getTotalPrice(){
        return cartItem.getTotalNetPrice().add(totalTaxes);
    }
}
