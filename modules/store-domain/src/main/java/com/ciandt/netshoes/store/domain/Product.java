package com.ciandt.netshoes.store.domain;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

/**
 * Created by erickpr on 08/03/16.
 */
public class Product {

    @Id
    private String id;

    private String name;

    private String description;

    private Category category;

    private BigDecimal price;

    private BigDecimal stock;

    public Product() {
        this.category = new Category();
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(final Category category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(final BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(final BigDecimal stock) {
        this.stock = stock;
    }
}
