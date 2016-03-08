package com.ciandt.netshoes.store.domain;

import org.springframework.data.annotation.Id;

/**
 * Created by erickpr on 08/03/16.
 */
public class Product {

    @Id
    private String id;

    private String name;

    private String description;
}
