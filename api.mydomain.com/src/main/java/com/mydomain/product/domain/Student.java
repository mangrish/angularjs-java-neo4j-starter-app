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
public class Student
{
    @Inject
    private static StudentRepository studentRepository;

    public static Iterable<Student> findAll()
    {
        return studentRepository.findAll();
    }

    private Long id;

    private String name;

    @Relationship(type = "ENROLLED")
    private Set<Enrollment> enrollments;

    @Relationship(type = "BUDDY", direction = Relationship.INCOMING)
    private Set<StudyBuddy> studyBuddies;

    public Student()
    {
        this.studyBuddies = new HashSet<>();
        this.enrollments = new HashSet<>();
    }

    public Student(String name)
    {
        this.name = name;
    }


    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }
}
