package com.mydomain.product.domain;

import com.mydomain.product.persistence.Repository;
import org.neo4j.ogm.annotation.Transient;

import java.util.Map;

/**
 * Created by markangrish on 10/04/2016.
 */
@Transient
public interface StudyBuddyRepository extends Repository<StudyBuddy>
{
    Iterable<Map<String,Object>> getStudyBuddiesByPopularity();
}
