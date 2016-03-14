package com.ciandt.netshoes.store.service;

import com.ciandt.netshoes.store.domain.Catalog;

import java.time.LocalDate;

/**
 * Created by erickpr on 11/03/16.
 */
public interface CatalogService {

    Catalog getCurrent(LocalDate localDate);
}
