package com.ciandt.netshoes.store.service.impl;

import com.ciandt.netshoes.store.dao.CatalogDao;
import com.ciandt.netshoes.store.domain.Catalog;
import com.ciandt.netshoes.store.service.CatalogService;
import com.ciandt.netshoes.store.utils.DateTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * Created by erickpr on 11/03/16.
 */
@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private CatalogDao catalogDao;

    @Override
    public Catalog getCurrent(final LocalDate localDate) {
        return catalogDao.getCurrent(DateTools.localDateToDate(localDate));
    }
}
