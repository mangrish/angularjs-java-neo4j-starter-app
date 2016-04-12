package com.mydomain.product.persistence.impl.neo4j;

import com.mydomain.product.domain.Department;
import com.mydomain.product.domain.School;
import com.mydomain.product.domain.SchoolRepository;

/**
 * Created by markangrish on 10/04/2016.
 */
public class Neo4jSchoolRepositoryImpl extends Neo4jGenericRepositoryImpl<School> implements SchoolRepository
{
    Neo4jSchoolRepositoryImpl()
    {
        super(School.class);
    }
}
