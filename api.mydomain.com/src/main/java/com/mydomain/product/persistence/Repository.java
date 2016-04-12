package com.mydomain.product.persistence;

/**
 * Created by markangrish on 11/04/2016.
 */

public interface Repository<T>
{
    Iterable<T> findAll();

    T findById(Long id);

    void delete(T entity);

    void save(T entity);
}
