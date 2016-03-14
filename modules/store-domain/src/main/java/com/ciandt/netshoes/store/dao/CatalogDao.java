package com.ciandt.netshoes.store.dao;

import com.ciandt.netshoes.store.domain.Catalog;

import java.util.Date;

/**
 * Created by erickpr on 11/03/16.
 */
public interface CatalogDao {

    Catalog getCurrent(Date current);

    Catalog save(Catalog catalog);
}
