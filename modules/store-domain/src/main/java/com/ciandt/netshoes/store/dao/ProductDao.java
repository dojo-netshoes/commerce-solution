package com.ciandt.netshoes.store.dao;

import com.ciandt.netshoes.store.domain.Product;

import java.util.List;

/**
 * Created by erickpr on 08/03/16.
 */
public interface ProductDao {

    Product persist(Product product);

    List<Product> persist(List<Product> products);

    void remove(Product product);

    void remove(List<Product> products);

    void remove(String id);

    List<Product> findAll();

    Product findById(String id);
}
