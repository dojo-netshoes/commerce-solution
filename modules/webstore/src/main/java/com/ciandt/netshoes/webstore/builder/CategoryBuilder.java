package com.ciandt.netshoes.webstore.builder;

import com.ciandt.netshoes.webstore.domain.Category;

/**
 * Created by erickpr on 14/03/16.
 */
public class CategoryBuilder {
    private final Category category;

    private CategoryBuilder() {
        category = new Category();
    }

    public static CategoryBuilder aCategory() {
        return new CategoryBuilder();
    }

    public CategoryBuilder withId(final Long id) {
        this.category.setId(id);
        return this;
    }

    public CategoryBuilder withName(final String name) {
        this.category.setName(name);
        return this;
    }

    public CategoryBuilder withParent(final Category parent) {
        this.category.setParent(parent);
        return this;
    }

    public Category build() {
        return category;
    }
}
