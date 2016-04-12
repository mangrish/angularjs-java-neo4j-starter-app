package com.mydomain.product.web.api.v1.resources;

/**
 * Created by markangrish on 10/04/2016.
 */
public class School
{
    public Long id;

    public String name;

    public School()
    {
    }

    public School(com.mydomain.product.domain.School school)
    {
        this.id = school.getId();
        this.name = school.getName();
    }
}
