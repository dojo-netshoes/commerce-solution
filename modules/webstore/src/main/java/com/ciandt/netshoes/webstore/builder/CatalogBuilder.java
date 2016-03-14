package com.ciandt.netshoes.webstore.builder;

import com.ciandt.netshoes.webstore.domain.Banner;
import com.ciandt.netshoes.webstore.domain.Catalog;
import com.ciandt.netshoes.webstore.domain.Product;
import com.google.common.collect.Lists;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * Created by erickpr on 11/03/16.
 */
public class CatalogBuilder {
    private final Catalog catalog;

    private CatalogBuilder() {
        catalog = new Catalog();
    }

    public static CatalogBuilder aCatalog() {
        return new CatalogBuilder();
    }

    public CatalogBuilder withId(final Long id) {
        this.catalog.setId(id);
        return this;
    }

    public CatalogBuilder withCatalogDay(final LocalDateTime catalogDay) {
        this.catalog
            .setCatalogDay(Date.from(catalogDay.atZone(ZoneId.systemDefault()).toInstant()));
        return this;
    }

    public CatalogBuilder withCatalogDay(final Date catalogDay) {
        this.catalog.setCatalogDay(catalogDay);
        return this;
    }

    public CatalogBuilder withBanners(final List<Banner> banners) {
        this.catalog.setBanners(banners);
        return this;
    }

    public CatalogBuilder withBanner(final Banner banner) {
        if (this.catalog.getBanners() == null) {
            this.catalog.setBanners(Lists.newArrayList());
        }
        this.catalog.getBanners().add(banner);
        return this;
    }

    public CatalogBuilder withBanner(final String banner) {
        if (this.catalog.getBanners() == null) {
            this.catalog.setBanners(Lists.newArrayList());
        }
        this.catalog.getBanners().add(new Banner(banner));
        return this;
    }

    public CatalogBuilder withProducts(final List<Product> products) {
        this.catalog.setProducts(products);
        return this;
    }

    public CatalogBuilder withProduct(final Product product) {
        if (this.catalog.getProducts() == null) {
            this.catalog.setProducts(Lists.newArrayList());
        }
        this.catalog.getProducts().add(product);
        return this;
    }


    public Catalog build() {
        return catalog;
    }
}
