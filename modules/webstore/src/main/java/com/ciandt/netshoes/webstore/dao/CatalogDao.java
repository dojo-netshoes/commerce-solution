package com.ciandt.netshoes.webstore.dao;

import com.ciandt.netshoes.webstore.domain.Catalog;

import java.util.Date;
import java.util.List;

/**
 * Created by erickpr on 14/03/16.
 */
public interface CatalogDao {

    Catalog save(Catalog catalog);

    Catalog findById(Long id);


    List<Catalog> findAll();


    void remove(Catalog catalog);

    Catalog findByCatalogDay(Date date);

}
