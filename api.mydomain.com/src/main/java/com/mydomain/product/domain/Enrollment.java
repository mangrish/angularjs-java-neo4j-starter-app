package com.mydomain.product.domain;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.neo4j.ogm.annotation.typeconversion.DateLong;

import java.time.LocalDate;

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
    private LocalDate enrolledDate;

    public Enrollment()
    {
    }

    public Enrollment(Student student, Course course)
    {
        this.student = student;
        this.course = course;
        this.enrolledDate = LocalDate.now();
    }
}
