package com.ciandt.netshoes.webstore.bootstrap;

import com.ciandt.netshoes.webstore.bootstrap.service.DatabasePopulatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by erickpr on 11/03/16.
 */
@Component
public class DatabasePopulator {

    @Autowired
    DatabasePopulatorService databasePopulatorService;


    @PostConstruct
    void init() {
        databasePopulatorService.execute();
    }
}
