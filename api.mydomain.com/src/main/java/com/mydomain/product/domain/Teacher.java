package com.mydomain.product.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by markangrish on 10/04/2016.
 */
@NodeEntity
public class Teacher
{
    @Inject
    private static TeacherRepository teacherRespository;

    public static Iterable<Teacher> findAll()
    {
        return teacherRespository.findAll();
    }

    public static Teacher findById(Long id)
    {
        return teacherRespository.findById(id);
    }

    private Long id;

    private String name;

    Set<Course> courses;

    @Relationship(type = "DEPARTMENT_MEMBER", direction = Relationship.INCOMING)
    Department department;

    @Relationship(type = "TAUGHT_BY", direction = Relationship.INCOMING)
    Set<Subject> subjects;

    public Teacher()
    {
        this.courses = new HashSet<>();
        this.subjects = new HashSet<>();
    }

    public Teacher(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public Set<Subject> getSubjects()
    {
        return subjects;
    }

    public Long getId()
    {
        return id;
    }


}
