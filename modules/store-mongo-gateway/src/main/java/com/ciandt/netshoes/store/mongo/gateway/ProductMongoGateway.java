package com.ciandt.netshoes.store.mongo.gateway;

import com.ciandt.netshoes.store.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.Serializable;

/**
 * Created by erickpr on 08/03/16.
 */
public interface ProductMongoGateway extends MongoRepository<Product, Serializable> {
}
