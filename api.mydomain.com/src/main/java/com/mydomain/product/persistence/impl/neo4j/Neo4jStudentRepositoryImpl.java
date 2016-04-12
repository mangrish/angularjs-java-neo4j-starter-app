package com.mydomain.product.persistence.impl.neo4j;

import com.mydomain.product.domain.Student;
import com.mydomain.product.domain.StudentRepository;

/**
 * Created by markangrish on 10/04/2016.
 */
public class Neo4jStudentRepositoryImpl extends Neo4jGenericRepositoryImpl<Student> implements StudentRepository
{
    Neo4jStudentRepositoryImpl()
    {
        super(Student.class);
    }
}
