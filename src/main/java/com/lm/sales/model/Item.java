package com.lm.sales.model;

public class Item {

    private Long id;

    private String productCode;

    private String description;

    private Category category;

    public Item(Long id, String productCode, String description, Category category) {
        this.id = id;
        this.productCode = productCode;
        this.description = description;
        this.category = category;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
