package com.ciandt.netshoes.store.mongo.gateway;

import com.ciandt.netshoes.store.domain.Catalog;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by erickpr on 11/03/16.
 */
public interface CatalogMongoGateway extends MongoRepository<Catalog, Serializable> {

    Catalog findByCatalogDay(Date date);
}
