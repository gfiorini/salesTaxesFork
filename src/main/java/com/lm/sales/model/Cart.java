package com.lm.sales.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Cart {

    private Map<String, CartItem> items = new LinkedHashMap<String, CartItem>();

    public void addItem(Item item, Amount price){
        addItems(item, price, false, 1);
    }

    public void addItem(Item item, Amount price, boolean flgImported){
        addItems(item, price, flgImported, 1);
    }

    public void addItems(Item item, Amount price, boolean flgImported, long quantity){

        String key = buildKey(item, flgImported);

        CartItem cartItem = items.get(key);
        if (cartItem == null){
            items.put(key, new CartItem(item, price, flgImported, quantity));
        } else {
            cartItem.add(quantity);
        }
    }

    public List<String> toList(){
        List l = new ArrayList();
        for (CartItem c: items.values()){
            l.add(buildString(c));
        }
        return l;
    }

    private String buildString(CartItem c) {
        StringBuilder sb = new StringBuilder();
        sb.append(c.getQuantity()).append(" ").append(c.getInstance().getDescription()).append(" at ").append((c.getPrice().multiply(c.getQuantity()).getValue()));
        return sb.toString();
    }

    public String buildKey(Item item, boolean flgImported) {
        return new StringBuilder().append(item.getProductCode()).append("_").append(flgImported).toString();
    }

    public Map<String, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<String, CartItem> items) {
        this.items = items;
    }





}
