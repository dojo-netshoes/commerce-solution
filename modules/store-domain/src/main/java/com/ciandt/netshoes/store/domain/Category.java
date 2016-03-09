package com.ciandt.netshoes.store.domain;

import com.ciandt.netshoes.store.shared.domain.GenericDomain;
import org.springframework.data.annotation.Id;

/**
 * Created by erickpr on 09/03/16.
 */
public class Category extends GenericDomain {

    @Id
    private String id;
    private String name;
    private Category parent;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getParent() {
        return parent;
    }
}
