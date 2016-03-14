package com.ciandt.netshoes.store.builder;

import com.ciandt.netshoes.store.domain.Catalog;
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

    public CatalogBuilder withId(final String id) {
        this.catalog.setId(id);
        return this;
    }

    public CatalogBuilder withCatalogDay(final LocalDateTime catalogDay) {
        this.catalog
            .setCatalogDay(Date.from(catalogDay.atZone(ZoneId.systemDefault()).toInstant()));
        return this;
    }

    public CatalogBuilder withCatalogDay(final java.util.Date catalogDay) {
        this.catalog.setCatalogDay(catalogDay);
        return this;
    }

    public CatalogBuilder withBanners(final List<String> banners) {
        this.catalog.setBanners(banners);
        return this;
    }

    public CatalogBuilder withBanner(final String banner) {
        if (this.catalog.getBanners() == null) {
            this.catalog.setBanners(Lists.newArrayList());
        }
        this.catalog.getBanners().add(banner);
        return this;
    }


    public Catalog build() {
        return catalog;
    }
}
