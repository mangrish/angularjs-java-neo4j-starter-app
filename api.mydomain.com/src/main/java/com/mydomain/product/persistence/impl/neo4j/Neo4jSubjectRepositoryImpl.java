package com.mydomain.product.persistence.impl.neo4j;

import com.mydomain.product.domain.Subject;
import com.mydomain.product.domain.SubjectRepository;

/**
 * Created by markangrish on 10/04/2016.
 */
public class Neo4jSubjectRepositoryImpl extends Neo4jGenericRepositoryImpl<Subject> implements SubjectRepository
{
    Neo4jSubjectRepositoryImpl()
    {
        super(Subject.class);
    }
}
