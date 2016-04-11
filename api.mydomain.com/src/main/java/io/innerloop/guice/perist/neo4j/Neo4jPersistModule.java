package io.innerloop.guice.perist.neo4j;

import com.google.inject.Singleton;
import com.google.inject.name.Names;
import com.google.inject.persist.PersistModule;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.UnitOfWork;
import org.aopalliance.intercept.MethodInterceptor;
import org.neo4j.ogm.session.Session;

/**
 * Created by markangrish on 11/04/2016.
 */
public class Neo4jPersistModule extends PersistModule
{
    private final String url;

    private final String username;

    private final String password;

    private final String[] packages;

    private MethodInterceptor transactionInterceptor;

    public Neo4jPersistModule(String url, String username, String password, String... packages)
    {
        this.url = url;
        this.username = username;
        this.password = password;
        this.packages = packages;
    }

    @Override
    protected void configurePersistence()
    {
        bind(String[].class).annotatedWith(Names.named("neo4j.ogm.packages")).toInstance(packages);
        bind(String.class).annotatedWith(Names.named("neo4j.ogm.url")).toInstance(url);
        bind(String.class).annotatedWith(Names.named("neo4j.ogm.username")).toInstance(username);
        bind(String.class).annotatedWith(Names.named("neo4j.ogm.password")).toInstance(password);

        bind(Neo4jPersistService.class).in(Singleton.class);
        bind(PersistService.class).to(Neo4jPersistService.class);
        bind(UnitOfWork.class).to(Neo4jPersistService.class);
        bind(Session.class).toProvider(Neo4jPersistService.class);

        transactionInterceptor = new Neo4jLocalTxnInterceptor();
        requestInjection(transactionInterceptor);
    }

    @Override
    protected MethodInterceptor getTransactionInterceptor()
    {
        return this.transactionInterceptor;
    }
}
