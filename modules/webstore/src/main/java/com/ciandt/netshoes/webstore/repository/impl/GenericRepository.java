package com.ciandt.netshoes.webstore.repository.impl;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenericRepository<T, ID extends Serializable> {

    @PersistenceContext(unitName = "WebStorePersistence")
    private EntityManager entityManager;

    private final Class<T> entityBeanType;

    @SuppressWarnings({"unchecked", "rawtypes"})
    public GenericRepository() {
        final Type genericSuperclass = getClass().getGenericSuperclass();
        final ParameterizedType type = (ParameterizedType) genericSuperclass;
        this.entityBeanType = ((Class) type.getActualTypeArguments()[0]);
    }

    public void setEntityManager(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    protected EntityManager getEntityManager() {
        if (this.entityManager == null) {
            throw new IllegalStateException("EntityManager has not been set on DAO before usage");
        }
        return this.entityManager;
    }

    protected Class<T> getEntityBeanType() {
        return this.entityBeanType;
    }


    @Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = Exception.class)
    public T findById(final ID id) {
        final Object entity = getEntityManager().find(getEntityBeanType(), id);
        return (T) entity;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public T persist(final T entity) {
        return getEntityManager().merge(entity);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public void remove(final T entity) {
        getEntityManager().remove(entity);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = Exception.class)
    public List<T> findAll() {
        final Query query =
            getEntityManager().createQuery("SELECT e FROM " + getEntityBeanType().getName() + " e");
        return query.getResultList();
    }

    protected List<T> clear(final List<T> rows) {
        final Set<T> temp = new HashSet<T>();
        temp.addAll(rows);
        return new ArrayList<T>(temp);
    }

}
