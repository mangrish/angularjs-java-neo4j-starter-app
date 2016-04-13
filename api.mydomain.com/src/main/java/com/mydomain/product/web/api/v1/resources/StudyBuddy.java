package com.mydomain.product.web.api.v1.resources;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by markangrish on 10/04/2016.
 */
public class StudyBuddy
{
    public static Function<com.mydomain.product.domain.StudyBuddy, StudyBuddy> create = t -> {
        StudyBuddy studyBuddy = new StudyBuddy();
        studyBuddy.id = t.getId();
        studyBuddy.course = Course.create.apply(t.getCourse());
        studyBuddy.buddies = t.getBuddies().stream().map(Student.create).collect(Collectors.toList());
        return studyBuddy;
    };

    public Long id;

    public List<Student> buddies;

    public Course course;
}
