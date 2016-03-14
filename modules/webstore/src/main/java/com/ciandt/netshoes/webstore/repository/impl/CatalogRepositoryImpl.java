package com.ciandt.netshoes.webstore.repository.impl;

import com.ciandt.netshoes.webstore.domain.Catalog;
import com.ciandt.netshoes.webstore.repository.CatalogRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by erickpr on 14/03/16.
 */
@Repository
public class CatalogRepositoryImpl extends GenericRepository<Catalog, Serializable>
    implements CatalogRepository {

    @Override
    public Catalog findById(final Long id) {
        return super.findById(id);
    }

    @Override
    public Catalog findByCatalogDay(final Date currentDay) {
        final String hql = "SELECT c FROM Catalog c JOIN FETCH c.products";
        final Query query = getEntityManager().createQuery(hql, Catalog.class);
        return (Catalog) query.getSingleResult();
    }
}
