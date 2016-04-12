package com.mydomain.product.persistence.impl.neo4j;

import com.mydomain.product.domain.StudyBuddy;
import com.mydomain.product.domain.StudyBuddyRepository;

import java.util.Collections;
import java.util.Map;

/**
 * Created by markangrish on 10/04/2016.
 */
public class Neo4jStudyBuddyRepositoryImpl extends Neo4jGenericRepositoryImpl<StudyBuddy>
        implements StudyBuddyRepository
{
    Neo4jStudyBuddyRepositoryImpl()
    {
        super(StudyBuddy.class);
    }

    @Override
    public Iterable<Map<String, Object>> getStudyBuddiesByPopularity()
    {
        String query = "MATCH (s:StudyBuddy)<-[:BUDDY]-(p:Student) return p, count(s) as buddies ORDER BY buddies DESC";

        return session.query(query, Collections.EMPTY_MAP);
    }
}
