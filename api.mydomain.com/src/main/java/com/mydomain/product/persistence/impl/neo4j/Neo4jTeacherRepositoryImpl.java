package com.mydomain.product.persistence.impl.neo4j;

import com.mydomain.product.domain.TeacherRepository;
import com.mydomain.product.domain.Teacher;

/**
 * Created by markangrish on 10/04/2016.
 */
public class Neo4jTeacherRepositoryImpl extends Neo4jGenericRepositoryImpl<Teacher> implements TeacherRepository
{
    Neo4jTeacherRepositoryImpl()
    {
        super(Teacher.class);
    }
}
