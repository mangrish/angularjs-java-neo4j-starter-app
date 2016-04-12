package com.mydomain.product.persistence.impl.neo4j;

import com.mydomain.product.domain.Course;
import com.mydomain.product.domain.CourseRepository;

/**
 * Created by markangrish on 10/04/2016.
 */
public class Neo4jCourseRepositoryImpl extends Neo4jGenericRepositoryImpl<Course> implements CourseRepository
{
    Neo4jCourseRepositoryImpl()
    {
        super(Course.class);
    }
}
