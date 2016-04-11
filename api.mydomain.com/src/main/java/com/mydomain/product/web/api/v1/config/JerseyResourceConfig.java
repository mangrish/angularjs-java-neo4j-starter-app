package com.mydomain.product.web.api.v1.config;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;

import javax.inject.Inject;

/**
 * Created by markangrish on 10/04/2016.
 */
public class JerseyResourceConfig extends ResourceConfig
{
    @Inject
    public JerseyResourceConfig(ServiceLocator locator)
    {
        this.packages("com.mydomain.product.web.api.v1.service");

        GuiceBridge.getGuiceBridge().initializeGuiceBridge(locator);
        GuiceIntoHK2Bridge guiceBridge = locator.getService(GuiceIntoHK2Bridge.class);
        //        Injector injector = Guice.createInjector(new GuiceConfigModule());
        guiceBridge.bridgeGuiceInjector(JerseyGuiceServletContextListener.injector);

        this.register(LoggingFilter.class);
        this.register(RolesAllowedDynamicFeature.class);
        this.register(CorsResponseFilter.class);
        this.register(JacksonFeature.class);
        this.register(JacksonObjectMapperProvider.class);
    }
}
