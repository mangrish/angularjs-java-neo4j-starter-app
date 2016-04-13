package com.mydomain.product.web.api.v1.resources;

import com.mydomain.product.web.api.v1.resources.views.DepartmentDetailView;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by markangrish on 10/04/2016.
 */
public class Department
{
    public Long id;

    public String name;

    @DepartmentDetailView
    public Set<Subject> subjects;

    public Department()
    {
    }

    public Department(com.mydomain.product.domain.Department department)
    {
        this.id = department.getId();
        this.name = department.getName();
        this.subjects = department.getSubjects().stream().map(Subject::new).collect(Collectors.toSet());
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setSubjects(Set<Subject> subjects)
    {
        this.subjects = subjects;
    }

    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public Set<Subject> getSubjects()
    {
        return subjects;
    }
}
