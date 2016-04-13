package com.mydomain.product.web.api.v1.resources;

import java.util.Date;
import java.util.function.Function;

/**
 * Created by markangrish on 13/04/2016.
 */
public class Enrollment
{
    public static Function<com.mydomain.product.domain.Enrollment, Enrollment> create = t -> {
        Enrollment enrollment = new Enrollment();
        enrollment.id = t.getId();
        enrollment.ennrolledDate = t.getEnnrolledDate();

        return enrollment;
    };

    public Long id;

    public Date ennrolledDate;
}
