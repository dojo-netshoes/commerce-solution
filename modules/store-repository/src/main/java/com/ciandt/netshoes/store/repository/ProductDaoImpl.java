package com.ciandt.netshoes.store.repository;

import com.ciandt.netshoes.store.dao.ProductDao;
import com.ciandt.netshoes.store.domain.Product;
import com.ciandt.netshoes.store.mongo.gateway.ProductMongoGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by erickpr on 08/03/16.
 */
@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private ProductMongoGateway productMongoGateway;

    @Override
    public Product persist(final Product product) {
        return productMongoGateway.save(product);
    }

    @Override
    public List<Product> persist(final List<Product> products) {
        return productMongoGateway.save(products);
    }

    @Override
    public void remove(final Product product) {
        productMongoGateway.delete(product);
    }

    @Override
    public void remove(final List<Product> products) {
        productMongoGateway.delete(products);
    }

    @Override
    public void remove(final String id) {
        productMongoGateway.delete(id);
    }

    @Override
    public List<Product> findAll() {
        return productMongoGateway.findAll();
    }

    @Override
    public Product findById(final String id) {
        return productMongoGateway.findOne(id);
    }
}
