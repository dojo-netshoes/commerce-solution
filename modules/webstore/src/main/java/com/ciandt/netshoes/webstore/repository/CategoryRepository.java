package com.ciandt.netshoes.webstore.repository;

import com.ciandt.netshoes.webstore.domain.Category;

import java.util.List;

/**
 * Created by erickpr on 14/03/16.
 */
public interface CategoryRepository {

    Category persist(Category category);

    void remove(Category category);

    Category findById(Long id);

    List<Category> findAll();
}
