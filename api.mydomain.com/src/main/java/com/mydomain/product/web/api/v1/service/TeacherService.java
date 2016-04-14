package com.mydomain.product.web.api.v1.service;

import com.google.inject.persist.Transactional;
import com.mydomain.product.domain.Teacher;
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
@Path("/teachers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional(ignore = WebApplicationException.class)
public class TeacherService
{
    private static final Logger LOG = LoggerFactory.getLogger(TeacherService.class);

    @GET
    public Iterable<com.mydomain.product.web.api.v1.resources.Teacher> findAll()
    {
        LOG.trace("Retrieving all Teachers");

        Iterable<Teacher> teachers = Teacher.findAll();

        return StreamSupport.stream(teachers.spliterator(), false)
                       .map(com.mydomain.product.web.api.v1.resources.Teacher.create)
                       .collect(Collectors.toList());
    }

    @GET
    @Path("{id}")
    @ResourceDetailView
    public com.mydomain.product.web.api.v1.resources.Teacher find(@PathParam("id") Long id)
    {
        LOG.trace("Retrieving Teacher with ID: [{}]", id);

        Teacher teacher = Teacher.findById(id);

        if (teacher == null)
        {
            throw new NotFoundException("Teacher not found.");
        }

        return com.mydomain.product.web.api.v1.resources.Teacher.createDetailed.apply(teacher);
    }
}
