package com.mydomain.product.domain;

import javax.inject.Inject;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by markangrish on 10/04/2016.
 */
@NodeEntity
public class Subject
{
    @Inject
    private static SubjectRepository subjectRepository;

    public static Iterable<Subject> findAll()
    {
        return subjectRepository.findAll();
    }

    private Long id;

    private String name;

    @Relationship(type = "CURRICULUM", direction = Relationship.INCOMING)
    private Department department;

    @Relationship(type = "TAUGHT_BY")
    private Set<Teacher> teachers;

    @Relationship(type = "SUBJECT_TAUGHT", direction = Relationship.INCOMING)
    private Set<Course> courses;

    public Subject()
    {
        this.teachers = new HashSet<>();
        this.courses = new HashSet<>();
    }

    public Subject(String name)
    {
        this.name = name;
    }


    public String getName()
    {
        return name;
    }

    public Set<Teacher> getTeachers()
    {
        return teachers;
    }

    public Long getId()
    {
        return id;
    }
}
