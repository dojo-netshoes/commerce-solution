package com.ciandt.netshoes.store.bootstrap;

import com.ciandt.netshoes.store.bootstrap.service.MongoPopulatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by erickpr on 11/03/16.
 */
@Component
public class MongoPopulator {

    @Autowired
    MongoPopulatorService mongoPopulatorService;


    @PostConstruct
    void init() {
        mongoPopulatorService.execute();
    }
}
