package com.mydomain.product.domain;

import com.google.inject.Inject;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by markangrish on 10/04/2016.
 */
@NodeEntity(label = "Class")
public class Course
{
    @Inject
    private static CourseRepository courseRepository;

    public static Iterable<Course> findAll()
    {
        return courseRepository.findAll();
    }

    private Long id;

    private String name;

    @Relationship(type = "SUBJECT_TAUGHT")
    private Subject subject;

    @Relationship(type = "TEACHES_CLASS", direction = Relationship.INCOMING)
    private Teacher teacher;

    @Relationship(type = "ENROLLED", direction = Relationship.INCOMING)
    private Set<Enrollment> enrollments;

    public Course()
    {
        this.enrollments = new HashSet<>();
    }


}
