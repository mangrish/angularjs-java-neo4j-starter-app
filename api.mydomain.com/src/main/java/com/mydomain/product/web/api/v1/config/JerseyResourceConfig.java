package com.mydomain.product.web.api.v1.config;

import com.mydomain.product.web.api.v1.resources.views.DepartmentDetailView;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.message.filtering.EntityFilteringFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;

import javax.inject.Inject;
import java.lang.annotation.Annotation;

/**
 * Created by markangrish on 10/04/2016.
 */
public class JerseyResourceConfig extends ResourceConfig
{
    @Inject
    public JerseyResourceConfig(ServiceLocator locator)
    {
        //http://stackoverflow.com/questions/35085267/guice-dont-inject-to-jerseys-resources
        this.register(GuiceFeature.class);
        this.property(EntityFilteringFeature.ENTITY_FILTERING_SCOPE,
                      new Annotation[] {DepartmentDetailView.Factory.get()});
        this.register(EntityFilteringFeature.class);
        this.packages("com.mydomain.product.web.api.v1.service");

        this.register(LoggingFilter.class);
        this.register(RolesAllowedDynamicFeature.class);
        this.register(CorsResponseFilter.class);
        this.register(JacksonFeature.class);
        this.register(JacksonObjectMapperProvider.class);
    }
}
