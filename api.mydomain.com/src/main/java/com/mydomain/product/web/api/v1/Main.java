package com.mydomain.product.web.api.v1;


import com.google.inject.persist.PersistFilter;
import com.google.inject.servlet.GuiceFilter;
import com.mydomain.product.web.api.v1.config.JerseyGuiceServletContextListener;
import com.mydomain.product.web.api.v1.config.JerseyResourceConfig;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.servlet.ServletRegistration;
import org.glassfish.grizzly.servlet.WebappContext;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.servlet.ServletContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.DispatcherType;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;
import java.util.EnumSet;

/**
 * Created by markangrish on 09/04/2016.
 */
public class Main
{

    private static Logger LOG = LoggerFactory.getLogger(Main.class);

    private static final String DEFAULT_PORT = "8080";

    private static final String DEFAULT_HOST_URI = "http://127.0.0.1/";

    private static final String DEFAULT_URL_PATTERN = "/v1/*";


    public static void main(String[] args)
    {
        int port = Integer.valueOf(System.getProperty("app.port", DEFAULT_PORT));

        URI baseUri = UriBuilder.fromUri(DEFAULT_HOST_URI).port(port).build();
        HttpServer httpServer = GrizzlyHttpServerFactory.createHttpServer(baseUri, false);

        WebappContext webappContext = new WebappContext("api.domain.com", "");

        webappContext.addListener(JerseyGuiceServletContextListener.class);

        ServletRegistration servletRegistration = webappContext.addServlet("ServletContainer", ServletContainer.class);
        servletRegistration.setInitParameter("javax.ws.rs.Application", JerseyResourceConfig.class.getName());
        servletRegistration.addMapping(DEFAULT_URL_PATTERN);

        webappContext.deploy(httpServer);

        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    httpServer.shutdownNow();
                }
                catch (Exception e)
                {
                    LOG.error("Error during the stopping of Jetty Web Server. See exception.", e);
                }
            }
        });

        LOG.info("Starting httpServer...");
        try
        {
            httpServer.start();
        }
        catch (IOException ioe)
        {
            LOG.error("Failed to start httpServer.", ioe);
        }
    }
}
