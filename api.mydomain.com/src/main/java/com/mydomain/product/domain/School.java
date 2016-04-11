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

public class School
{
    private Long id;

    private String name;

    @Relationship(type = "DEPARTMENT")
    private Set<Department> departments;

    @Relationship(type = "STAFF")
    private Set<Teacher> teachers;

    @Relationship(type = "HEAD_TEACHER")
    private Teacher headTeacher;

    @Relationship(type = "STUDENT")
    private Set<Student> students;

    public School()
    {
        this.departments = new HashSet<>();
        this.teachers = new HashSet<>();
        this.students = new HashSet<>();
    }

    public School(String name)
    {
        this.name = name;
    }

    @Inject
    private static SchoolRepository schoolRepository;

    public static Iterable<School> findAll()
    {
        return schoolRepository.findAll();
    }
}
