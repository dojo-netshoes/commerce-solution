package com.ciandt.netshoes.webstore;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by erickpr on 08/03/16.
 */
@Configuration
@ComponentScan(basePackages = "com.ciandt.netshoes.store")
public class SpringConfiguration implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
