package com.mydomain.product.domain;

import javax.inject.Inject;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by markangrish on 10/04/2016.
 */
@NodeEntity
public class StudyBuddy
{
    @Inject
    private static StudyBuddyRepository studyBuddyRepository;

    public static Iterable<StudyBuddy> findAll()
    {
        return studyBuddyRepository.findAll();
    }

    private Long id;

    @Relationship(type = "BUDDY")
    private List<Student> buddies;

    private Course course;

    public StudyBuddy()
    {
        buddies = new ArrayList<>();
    }

    public void addBuddy(Student buddy)
    {
        buddies.add(buddy);
    }

    public Student getBuddyTwo()
    {
        if (buddies.size() > 1)
        {
            return buddies.get(1);
        }
        else
        {
            return null;
        }
    }

    public Student getBuddyOne()
    {
        if (buddies.size() > 0)
        {
            return buddies.get(0);
        }
        else
        {
            return null;
        }
    }


    public List<Student> getBuddies()
    {
        return buddies;
    }

    public Course getCourse()
    {
        return course;
    }

    public Long getId()
    {
        return id;
    }
}
