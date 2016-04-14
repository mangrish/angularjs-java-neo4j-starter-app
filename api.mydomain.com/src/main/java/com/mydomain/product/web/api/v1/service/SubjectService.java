package com.mydomain.product.web.api.v1.service;

import com.google.inject.persist.Transactional;
import com.mydomain.product.domain.Subject;
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

@Path("/subjects")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional(ignore = WebApplicationException.class)
public class SubjectService
{
    private static final Logger LOG = LoggerFactory.getLogger(SubjectService.class);

    @GET
    public Iterable<com.mydomain.product.web.api.v1.resources.Subject> findAll()
    {
        LOG.trace("Retrieving all Subjects");

        Iterable<Subject> subjects = Subject.findAll();

        return StreamSupport.stream(subjects.spliterator(), false)
                       .map(com.mydomain.product.web.api.v1.resources.Subject.create)
                       .collect(Collectors.toList());
    }

    @GET
    @Path("{id}")
    @ResourceDetailView
    public com.mydomain.product.web.api.v1.resources.Subject find(@PathParam("id") Long id)
    {
        LOG.trace("Retrieving Subject with ID: [{}]", id);

        Subject subject = Subject.findById(id);

        if (subject == null)
        {
            throw new NotFoundException("Subject not found.");
        }

        return com.mydomain.product.web.api.v1.resources.Subject.createDetailed.apply(subject);
    }
}
