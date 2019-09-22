package com.lm.sales.model;

import java.math.BigDecimal;

public class Amount {

    public static final String DEFAULT_CURRENCY = "EUR";

    private BigDecimal value;

    private String isoCurrencyCode;

    public Amount(BigDecimal value, String isoCurrencyCode) {
        this.value = value;
        this.isoCurrencyCode = isoCurrencyCode;
    }

    public Amount(BigDecimal value){
        this.value = value;
        this.isoCurrencyCode = DEFAULT_CURRENCY;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getIsoCurrencyCode() {
        return isoCurrencyCode;
    }

    public void setIsoCurrencyCode(String isoCurrencyCode) {
        this.isoCurrencyCode = isoCurrencyCode;
    }

    public Amount add(Amount taxes) {
        if (taxes.getIsoCurrencyCode().equals(isoCurrencyCode)){
            this.value = this.value.add(taxes.getValue());
            return this;
        } else {
            //todo: need to convert currency values (not implemented in this exercise for simplicity)
            throw new UnsupportedOperationException("TODO");
        }
    }

    public Amount multiply(long quantity){
        return new Amount(this.value.multiply(BigDecimal.valueOf(quantity)), this.isoCurrencyCode);
    }

    public Amount multiply(BigDecimal value){
        return new Amount(this.value.multiply(value), this.isoCurrencyCode);
    }


}
