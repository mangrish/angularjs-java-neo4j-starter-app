package com.mydomain.product.web.api.v1.resources.views;

import org.glassfish.hk2.api.AnnotationLiteral;
import org.glassfish.jersey.message.filtering.EntityFiltering;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by markangrish on 11/04/2016.
 */

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EntityFiltering
public @interface DepartmentDetailView
{
    /**
     * Factory class for creating instances of {@code ProjectDetailedView} annotation.
     */
    public static class Factory extends AnnotationLiteral<DepartmentDetailView> implements DepartmentDetailView
    {
        private Factory()
        {
        }

        public static DepartmentDetailView get()
        {
            return new Factory();
        }
    }
}
