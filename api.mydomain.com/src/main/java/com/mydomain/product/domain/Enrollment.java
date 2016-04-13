package com.mydomain.product.domain;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.neo4j.ogm.annotation.typeconversion.DateLong;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by markangrish on 10/04/2016.
 */
@RelationshipEntity(type = "ENROLLED")
public class Enrollment
{
    private Long id;

    @StartNode
    private Student student;

    @EndNode
    private Course course;

    @DateLong
    private Date enrolledDate;

    public Enrollment()
    {
    }

    public Enrollment(Student student, Course course)
    {
        this.student = student;
        this.course = course;
        this.enrolledDate = new Date();
    }

    public Long getId()
    {
        return id;
    }

    public Student getStudent()
    {
        return student;
    }

    public Course getCourse()
    {
        return course;
    }

    public Date getEnnrolledDate()
    {
        return enrolledDate;
    }
}
