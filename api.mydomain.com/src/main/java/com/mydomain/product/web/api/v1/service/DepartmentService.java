package com.mydomain.product.web.api.v1.service;

import com.google.inject.persist.Transactional;
import com.mydomain.product.domain.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by markangrish on 10/04/2016.
 */

@Path("/departments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional(ignore = WebApplicationException.class)
public class DepartmentService
{
    private static final Logger LOG = LoggerFactory.getLogger(DepartmentService.class);

    @GET
    public Iterable<com.mydomain.product.web.api.v1.resources.Department> findAll()
    {
        LOG.trace("Retrieving all Departments");

        Iterable<Department> departments = Department.findAll();

        return StreamSupport.stream(departments.spliterator(), false)
                       .map(com.mydomain.product.web.api.v1.resources.Department::new)
                       .collect(Collectors.toList());
    }
}
