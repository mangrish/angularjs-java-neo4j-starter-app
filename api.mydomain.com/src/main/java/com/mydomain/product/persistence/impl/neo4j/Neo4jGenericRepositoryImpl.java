package com.mydomain.product.persistence.impl.neo4j;

import com.google.inject.Inject;
import com.mydomain.product.persistence.Repository;
import org.neo4j.ogm.session.Session;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by markangrish on 11/04/2016.
 */
class Neo4jGenericRepositoryImpl<T> implements Repository<T>
{
    private static final int DEFAULT_QUERY_DEPTH = 1;

    private final Class<T> type;

    @Inject
    private Session session;

    Neo4jGenericRepositoryImpl()
    {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        this.type = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public Iterable<T> findAll()
    {
        return session.loadAll(type, DEFAULT_QUERY_DEPTH);
    }
}
