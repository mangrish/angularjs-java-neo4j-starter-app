package com.mydomain.product.web.api.v1.config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * Created by markangrish on 11/04/2016.
 */
public class JerseyGuiceServletContextListener extends GuiceServletContextListener
{
    static Injector injector;

    @Override
    protected Injector getInjector()
    {
        injector = Guice.createInjector(new GuiceConfigModule());
        return injector;
    }
}
