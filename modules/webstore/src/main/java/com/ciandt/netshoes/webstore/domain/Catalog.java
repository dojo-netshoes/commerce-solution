package com.ciandt.netshoes.webstore.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

/**
 * Created by erickpr on 11/03/16.
 */

@Entity
@Table(name = "CATALOG")
public class Catalog extends GenericDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "CATALOG_DAY")
    private Date catalogDay;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
        name = "CATALOG_BANNER", joinColumns = {
        @JoinColumn(name = "CATALOG", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "BANNER", nullable = false)})
    private List<Banner> banners;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
        name = "CATALOG_PRODUCT", joinColumns = {
        @JoinColumn(name = "CATALOG", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "PRODUCT", nullable = false)})
    private List<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Date getCatalogDay() {
        return catalogDay;
    }

    public void setCatalogDay(final Date catalogDay) {
        this.catalogDay = catalogDay;
    }

    public List<Banner> getBanners() {
        return banners;
    }

    public void setBanners(final List<Banner> banners) {
        this.banners = banners;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(final List<Product> products) {
        this.products = products;
    }
}
