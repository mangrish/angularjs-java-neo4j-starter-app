package com.mydomain.product.persistence;

/**
 * Created by markangrish on 11/04/2016.
 */
public interface Repository<T>
{
    Iterable<T> findAll();
}
