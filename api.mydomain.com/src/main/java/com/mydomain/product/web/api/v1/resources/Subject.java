package com.mydomain.product.web.api.v1.resources;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by markangrish on 10/04/2016.
 */
public class Subject
{
    public Long id;

    public String name;

    public Set<Teacher> teachers;

    public Subject()
    {
    }

    public Subject(com.mydomain.product.domain.Subject subject)
    {
        this.id = subject.getId();
        this.name = subject.getName();
        this.teachers = subject.getTeachers().stream().map(Teacher::new).collect(Collectors.toSet());
    }
}
