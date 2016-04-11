package com.mydomain.product.web.api.v1.resources;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by markangrish on 10/04/2016.
 */
public class Teacher
{
    public Long id;

    public Set<Subject> subjects;

    public String name;

    public Teacher()
    {
    }

    public Teacher(com.mydomain.product.domain.Teacher teacher)
    {
        this.id = teacher.getId();
        this.name = teacher.getName();
        this.subjects = teacher.getSubjects().stream().map(Subject::new).collect(Collectors.toSet());
    }
}
