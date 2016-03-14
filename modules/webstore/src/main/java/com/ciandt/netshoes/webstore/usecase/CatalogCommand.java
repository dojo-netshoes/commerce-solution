package com.ciandt.netshoes.webstore.usecase;

import com.ciandt.netshoes.webstore.dao.CatalogDao;
import com.ciandt.netshoes.webstore.domain.Catalog;
import com.ciandt.netshoes.webstore.utils.DateTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Created by erickpr on 14/03/16.
 */
@Component
public class CatalogCommand {

    @Autowired
    private CatalogDao catalogDao;

    public Catalog execute() {
        final LocalDate currentDay = LocalDate.now();
        final Catalog catalog = catalogDao.findByCatalogDay(DateTools.localDateToDate(currentDay));
        return catalog;
    }


}
