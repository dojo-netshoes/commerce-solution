package com.ciandt.netshoes.webstore.repository;

import com.ciandt.netshoes.webstore.domain.Catalog;

import java.util.Date;
import java.util.List;

/**
 * Created by erickpr on 14/03/16.
 */
public interface CatalogRepository {

    Catalog persist(Catalog catalog);

    Catalog findById(Long id);

    List<Catalog> findAll();

    void remove(Catalog catalog);

    Catalog findByCatalogDay(Date currentDay);

}
