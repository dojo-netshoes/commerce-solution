package com.ciandt.netshoes.webstore.dao.impl;

import com.ciandt.netshoes.webstore.dao.CatalogDao;
import com.ciandt.netshoes.webstore.domain.Catalog;
import com.ciandt.netshoes.webstore.repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by erickpr on 14/03/16.
 */
@Component
public class CatalogDaoImpl implements CatalogDao {

    @Autowired
    private CatalogRepository catalogRepository;

    @Override
    public Catalog save(final Catalog catalog) {
        return catalogRepository.persist(catalog);
    }

    @Override
    public Catalog findById(final Long id) {
        return catalogRepository.findById(id);
    }

    @Override
    public List<Catalog> findAll() {
        return catalogRepository.findAll();
    }

    @Override
    public void remove(final Catalog catalog) {
        catalogRepository.remove(catalog);
    }

    @Override
    public Catalog findByCatalogDay(final Date date) {
        return catalogRepository.findByCatalogDay(date);
    }
}
