package com.mydomain.product.domain;

import com.google.inject.Inject;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by markangrish on 10/04/2016.
 */
@NodeEntity
public class Department
{
    @Inject
    private static DepartmentRepository departmentRepository;

    public static Iterable<Department> findAll()
    {
        return departmentRepository.findAll();
    }

    private Long id;

    private String name;

    @Relationship(type = "DEPARTMENT_MEMBER")
    private Set<Teacher> teachers;

    @Relationship(type = "CURRICULUM")
    private Set<Subject> subjects;

    public Department()
    {
        this.teachers = new HashSet<>();
        this.subjects = new HashSet<>();
    }

    public Department(String name)
    {
        this.name = name;
    }


}


