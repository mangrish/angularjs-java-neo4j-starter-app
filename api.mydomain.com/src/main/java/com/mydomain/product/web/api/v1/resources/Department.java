package com.mydomain.product.web.api.v1.resources;

import com.mydomain.product.web.api.v1.resources.views.ResourceDetailView;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by markangrish on 10/04/2016.
 */
public class Department
{

    public static Function<com.mydomain.product.domain.Department, Department> create = t -> {
        Department department = new Department();
        department.id = t.getId();
        department.name = t.getName();
        return department;
    };

    public static Function<com.mydomain.product.domain.Department, Department> createDetailed = t -> {
        Department department = new Department();
        department.id = t.getId();
        department.name = t.getName();
        department.subjects = t.getSubjects().stream().map(Subject.create).collect(Collectors.toSet());
        return department;
    };

    public Long id;

    public String name;

    @ResourceDetailView
    public Set<Subject> subjects;
}
