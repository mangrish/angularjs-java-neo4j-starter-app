package com.mydomain.product.domain;

import com.mydomain.product.persistence.Repository;
import org.neo4j.ogm.annotation.Transient;

/**
 * Created by markangrish on 10/04/2016.
 */
@Transient
public interface TeacherRepository extends Repository<Teacher>
{
}
