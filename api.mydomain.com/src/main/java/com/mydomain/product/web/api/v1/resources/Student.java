package com.mydomain.product.web.api.v1.resources;

/**
 * Created by markangrish on 10/04/2016.
 */
public class Student
{
    public Long id;

    public String name;

    public Student(com.mydomain.product.domain.Student student)
    {
        this.id = student.getId();
        this.name = student.getName();
    }
}
