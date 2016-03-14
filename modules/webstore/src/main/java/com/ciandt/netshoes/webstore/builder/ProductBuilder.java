package com.ciandt.netshoes.webstore.builder;

import com.ciandt.netshoes.webstore.domain.Category;
import com.ciandt.netshoes.webstore.domain.Product;

import java.math.BigDecimal;

/**
 * Created by erickpr on 14/03/16.
 */
public class ProductBuilder {
    private final Product product;

    private ProductBuilder() {
        product = new Product();
    }

    public static ProductBuilder aProduct() {
        return new ProductBuilder();
    }

    public ProductBuilder withId(final Long id) {
        this.product.setId(id);
        return this;
    }

    public ProductBuilder withName(final String name) {
        this.product.setName(name);
        return this;
    }

    public ProductBuilder withDescription(final String description) {
        this.product.setDescription(description);
        return this;
    }

    public ProductBuilder withCategory(final Category category) {
        this.product.setCategory(category);
        return this;
    }

    public ProductBuilder withPrice(final BigDecimal price) {
        this.product.setPrice(price);
        return this;
    }

    public ProductBuilder withStock(final BigDecimal stock) {
        this.product.setStock(stock);
        return this;
    }

    public ProductBuilder withInstallments(final Integer installments) {
        this.product.setInstallments(installments);
        return this;
    }

    public ProductBuilder withPathImage(final String pathImage) {
        this.product.setPathImage(pathImage);
        return this;
    }

    public Product build() {
        return product;
    }
}
