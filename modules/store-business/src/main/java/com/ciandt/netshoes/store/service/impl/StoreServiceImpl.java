package com.ciandt.netshoes.store.service.impl;

import com.ciandt.netshoes.store.dao.ProductDao;
import com.ciandt.netshoes.store.domain.Product;
import com.ciandt.netshoes.store.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by erickpr on 08/03/16.
 */
@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product persist(final Product product) {
        return productDao.persist(product);
    }

    @Override
    public List<Product> persist(final List<Product> products) {
        return productDao.persist(products);
    }

    @Override
    public void remove(final Product product) {
        productDao.remove(product);
    }

    @Override
    public void remove(final List<Product> products) {
        productDao.remove(products);
    }

    @Override
    public void remove(final String id) {
        productDao.remove(id);
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product findById(final String id) {
        return productDao.findById(id);
    }
}
