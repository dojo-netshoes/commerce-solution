package com.ciandt.netshoes.store.domain;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

/**
 * Created by erickpr on 11/03/16.
 */

public class Catalog {

    @Id
    private String id;

    private Date catalogDay;

    private List<String> banners;

    private List<List<Product>> products;

    public Date getCatalogDay() {
        return catalogDay;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setCatalogDay(final Date catalogDay) {
        this.catalogDay = catalogDay;
    }

    public List<String> getBanners() {
        return banners;
    }

    public void setBanners(final List<String> banners) {
        this.banners = banners;
    }

    public List<List<Product>> getProducts() {
        return products;
    }

    public void setProducts(final List<List<Product>> products) {
        this.products = products;
    }
}
