package com.lm.sales.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<String, CartItem> items = new HashMap<String, CartItem>();

    public void addItem(Item item){
        addItems(item, 1);
    }

    public void addItems(Item item, long quantity){
        CartItem cartItem = items.get(item.getProductCode());
        if (cartItem == null){
            items.put(item.getProductCode(), new CartItem(item, quantity));
        } else {
            cartItem.add(quantity);
        }
    }

    public Map<String, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<String, CartItem> items) {
        this.items = items;
    }
}
