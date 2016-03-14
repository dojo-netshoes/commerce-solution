package com.ciandt.netshoes.store.bootstrap.service;

import com.ciandt.netshoes.store.builder.CatalogBuilder;
import com.ciandt.netshoes.store.dao.CatalogDao;
import com.ciandt.netshoes.store.domain.Catalog;
import com.ciandt.netshoes.store.utils.DateTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * Created by erickpr on 11/03/16.
 */
@Service
public class MongoPopulatorService {

    @Autowired
    private CatalogDao catalogDao;

    public void execute() {
        final LocalDate localDate = LocalDate.now();
        final Catalog catalog =
            CatalogBuilder.aCatalog().withCatalogDay(DateTools.localDateToDate(localDate))
                .withBanner("img/full4_gen_160311_ffffff_1366.jpg")
                .withBanner("img/full2_gen_160310_ffffff_1366.jpg")
                .withBanner("img/full4_gen_160311_ffffff_1366.jpg")
                .withBanner("full1_con_160301_ffffff_1366.jpg").build();
        catalogDao.save(catalog);
    }
}
