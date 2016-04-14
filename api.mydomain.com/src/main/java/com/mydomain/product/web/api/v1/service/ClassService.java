package com.mydomain.product.web.api.v1.service;

import com.google.inject.persist.Transactional;
import com.mydomain.product.domain.Course;
import com.mydomain.product.web.api.v1.resources.views.ResourceDetailView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by markangrish on 10/04/2016.
 */

@Path("/classes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional(ignore = WebApplicationException.class)
public class ClassService
{
    private static final Logger LOG = LoggerFactory.getLogger(ClassService.class);

    @GET
    public Iterable<com.mydomain.product.web.api.v1.resources.Course> findAll()
    {
        LOG.trace("Retrieving all Classes");

        Iterable<Course> courses = Course.findAll();

        return StreamSupport.stream(courses.spliterator(), false)
                       .map(com.mydomain.product.web.api.v1.resources.Course.create)
                       .collect(Collectors.toList());
    }

    @GET
    @Path("{id}")
    @ResourceDetailView
    public com.mydomain.product.web.api.v1.resources.Course find(@PathParam("id") Long id)
    {
        LOG.trace("Retrieving Class with ID: [{}]", id);

        Course course = Course.findById(id);

        if (course == null)
        {
            throw new NotFoundException("Class not found.");
        }

        return com.mydomain.product.web.api.v1.resources.Course.createDetailed.apply(course);
    }
}
