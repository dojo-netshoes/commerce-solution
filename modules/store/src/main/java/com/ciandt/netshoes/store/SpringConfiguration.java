package com.ciandt.netshoes.store;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by erickpr on 08/03/16.
 */
@Configuration
@ComponentScan(basePackages = "com.ciandt.netshoes.store")
@EnableMongoRepositories(basePackages = "com.ciandt.netshoes.store.mongo")
public class SpringConfiguration implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
