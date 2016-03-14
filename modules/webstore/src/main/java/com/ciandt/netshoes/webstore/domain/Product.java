package com.ciandt.netshoes.webstore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by erickpr on 08/03/16.
 */
@Entity
@Table(name = "PRODUCT")
public class Product extends GenericDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "CATEGORY", nullable = false)
    private Category category;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "STOCK")
    private BigDecimal stock;

    @Column(name = "INSTALLMENTS")
    private Integer installments;

    @Column(name = "PATH_IMAGE")
    private String pathImage;

    public Product() {
        this.category = new Category();
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
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

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(final Integer installments) {
        this.installments = installments;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(final String pathImage) {
        this.pathImage = pathImage;
    }
}
