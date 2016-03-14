package com.ciandt.netshoes.store.repository;

import com.ciandt.netshoes.store.dao.CatalogDao;
import com.ciandt.netshoes.store.domain.Catalog;
import com.ciandt.netshoes.store.mongo.gateway.CatalogMongoGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created by erickpr on 11/03/16.
 */
@Repository
public class CatalogDaoImpl implements CatalogDao {

    @Autowired
    private CatalogMongoGateway catalogMongoGateway;

    @Override
    public Catalog getCurrent(final Date current) {
        return catalogMongoGateway.findByCatalogDay(current);
    }

    @Override
    public Catalog save(final Catalog catalog) {
        return catalogMongoGateway.save(catalog);
    }
}
