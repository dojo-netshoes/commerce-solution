package com.ciandt.netshoes.webstore.repository;

import com.ciandt.netshoes.webstore.domain.Product;

import java.util.List;

/**
 * Created by erickpr on 14/03/16.
 */
public interface ProductRepository {

    Product persist(Product product);

    Product findById(Long id);

    void remove(Product product);

    List<Product> findAll();
}
