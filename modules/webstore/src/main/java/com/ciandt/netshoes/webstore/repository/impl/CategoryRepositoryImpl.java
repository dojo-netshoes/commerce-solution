package com.ciandt.netshoes.webstore.repository.impl;

import com.ciandt.netshoes.webstore.domain.Category;
import com.ciandt.netshoes.webstore.repository.CategoryRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by erickpr on 14/03/16.
 */
@Repository
public class CategoryRepositoryImpl extends GenericRepository<Category, Serializable>
    implements CategoryRepository {

    @Override
    public Category findById(final Long id) {
        return super.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return null;
    }
}
