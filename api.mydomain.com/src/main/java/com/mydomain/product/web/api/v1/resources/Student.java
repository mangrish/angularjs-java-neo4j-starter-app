package com.mydomain.product.web.api.v1.resources;

import com.mydomain.product.web.api.v1.resources.views.ResourceDetailView;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by markangrish on 10/04/2016.
 */
public class Student
{
    public static Function<com.mydomain.product.domain.Student, Student> create = t -> {
        Student student = new Student();
        student.id = t.getId();
        student.name = t.getName();
        return student;
    };

    public static Function<com.mydomain.product.domain.Student, Student> createDetailed = t -> {
        Student student = new Student();
        student.id = t.getId();
        student.name = t.getName();
        student.enrollments = t.getEnrollments().stream().map(Enrollment.create).collect(Collectors.toSet());
        student.studyBuddies = t.getStudyBuddies().stream().map(StudyBuddy.create).collect(Collectors.toSet());
        return student;
    };

    public Long id;

    public String name;

    @ResourceDetailView
    public Set<Enrollment> enrollments;

    @ResourceDetailView
    public Set<StudyBuddy> studyBuddies;

}
