package com.ciandt.netshoes.webstore;

import com.google.common.collect.Maps;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by erickpr on 14/03/16.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.ciandt.netshoes.webstore.repository"})
public class JpaConfiguration extends JpaBaseConfiguration {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
        final EntityManagerFactoryBuilder builder) {
        final LocalContainerEntityManagerFactoryBean ret =
            builder.dataSource(dataSource()).packages("com.ciandt.netshoes.webstore.domain")
                .persistenceUnit("WebStorePersistence").properties(jpaProperties()).build();
        ret.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
        ret.setPersistenceProviderClass(org.hibernate.jpa.HibernatePersistenceProvider.class);
        return ret;
    }

    private HashMap jpaProperties() {
        final HashMap hashMap = Maps.newHashMap();
        hashMap.put("hibernate.hbm2ddl.auto", "create-drop");
        hashMap.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        hashMap.put("show_sql", true);
        return hashMap;
    }

    @Bean
    public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }



    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/webstore");
        dataSource.setUsername("root");
        dataSource.setPassword("brutal");
        return dataSource;
    }

    @Override
    protected AbstractJpaVendorAdapter createJpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    @Override
    protected Map<String, Object> getVendorProperties() {
        final Map<String, Object> ret = new HashMap<>();
        return ret;
    }
}
