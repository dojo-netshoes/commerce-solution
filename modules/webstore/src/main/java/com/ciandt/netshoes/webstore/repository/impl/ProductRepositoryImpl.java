package com.ciandt.netshoes.webstore.repository.impl;

import com.ciandt.netshoes.webstore.domain.Product;
import com.ciandt.netshoes.webstore.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by erickpr on 14/03/16.
 */
@Repository
public class ProductRepositoryImpl extends GenericRepository<Product, Serializable>
    implements ProductRepository {

    @Override
    public Product findById(final Long id) {
        return super.findById(id);
    }
}
