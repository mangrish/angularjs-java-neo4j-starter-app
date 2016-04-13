package com.mydomain.product.web.api.v1.service;

import com.google.inject.persist.Transactional;
import com.mydomain.product.domain.Student;
import com.mydomain.product.web.api.v1.config.Gzip;
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

@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional(ignore = WebApplicationException.class)
@Gzip
public class StudentService
{
    private static final Logger LOG = LoggerFactory.getLogger(StudentService.class);

    @GET
    public Iterable<com.mydomain.product.web.api.v1.resources.Student> findAll()
    {
        LOG.trace("Retrieving all Students");

        Iterable<Student> students = Student.findAll();

        return StreamSupport.stream(students.spliterator(), false)
                       .map(com.mydomain.product.web.api.v1.resources.Student::new)
                       .collect(Collectors.toList());
    }
}
