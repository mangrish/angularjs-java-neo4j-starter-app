package com.mydomain.product.web.api.v1.resources;


import com.mydomain.product.web.api.v1.resources.views.ResourceDetailView;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by markangrish on 10/04/2016.
 */
public class Course
{
    public static Function<com.mydomain.product.domain.Course, Course> create = t -> {
        Course course = new Course();
        course.id = t.getId();
        course.name = t.getName();

        return course;
    };

    public static Function<com.mydomain.product.domain.Course, Course> createDetailed = t -> {
        Course course = new Course();
        course.id = t.getId();
        course.name = t.getName();
        course.subject = Subject.create.apply(t.getSubject());
        course.teacher = Teacher.create.apply(t.getTeacher());
        course.enrollments = t.getEnrollments().stream().map(Enrollment.create).collect(Collectors.toSet());

        return course;
    };

    public Long id;

    public String name;

    @ResourceDetailView
    public Subject subject;

    @ResourceDetailView
    public Teacher teacher;

    @ResourceDetailView
    public Set<Enrollment> enrollments;


}
