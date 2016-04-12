package com.mydomain.product.persistence.impl.neo4j;

import com.mydomain.product.domain.Course;
import com.mydomain.product.domain.Department;
import com.mydomain.product.domain.DepartmentRepository;

/**
 * Created by markangrish on 10/04/2016.
 */
public class Neo4jDepartmentRepositoryImpl extends Neo4jGenericRepositoryImpl<Department>
        implements DepartmentRepository
{
    Neo4jDepartmentRepositoryImpl()
    {
        super(Department.class);
    }
}
