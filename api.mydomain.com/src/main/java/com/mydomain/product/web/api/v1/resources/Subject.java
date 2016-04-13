package com.mydomain.product.web.api.v1.resources;

import com.mydomain.product.web.api.v1.resources.views.ResourceDetailView;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by markangrish on 10/04/2016.
 */
public class Subject
{
    public static Function<com.mydomain.product.domain.Subject, Subject> create = t -> {
        Subject subject = new Subject();
        subject.id = t.getId();
        subject.name = t.getName();
        return subject;
    };

    public static Function<com.mydomain.product.domain.Subject, Subject> createDetailed = t -> {
        Subject subject = new Subject();
        subject.id = t.getId();
        subject.name = t.getName();
        subject.teachers = t.getTeachers().stream().map(Teacher.create).collect(Collectors.toSet());
        return subject;
    };

    public Long id;

    public String name;

    @ResourceDetailView
    public Set<Teacher> teachers;


}
