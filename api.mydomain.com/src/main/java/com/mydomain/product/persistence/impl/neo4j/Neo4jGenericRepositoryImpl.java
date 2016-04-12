package com.mydomain.product.persistence.impl.neo4j;

import com.google.inject.persist.Transactional;
import com.mydomain.product.persistence.Repository;
import org.neo4j.ogm.session.Session;

import javax.inject.Inject;

/**
 * Created by markangrish on 11/04/2016.
 */
@Transactional
class Neo4jGenericRepositoryImpl<T> implements Repository<T>
{
    private static final int DEFAULT_QUERY_DEPTH = 1;

    private final Class<T> type;

    @Inject
    protected Session session;

    Neo4jGenericRepositoryImpl(Class<T> type)
    {
        this.type = type;
    }

    @Override
    public Iterable<T> findAll()
    {
        return session.loadAll(type, DEFAULT_QUERY_DEPTH);
    }

    @Override
    public T findById(Long id)
    {
        return session.load(type, id, DEFAULT_QUERY_DEPTH);
    }

    @Override
    public void delete(T entity)
    {
        session.delete(entity);
    }

    @Override
    public void save(T entity)
    {
        session.save(entity);
    }
}
