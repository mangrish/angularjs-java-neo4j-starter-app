package io.innerloop.guice.perist.neo4j;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.UnitOfWork;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

/**
 * Created by markangrish on 11/04/2016.
 */
class Neo4jPersistService implements Provider<Session>, UnitOfWork, PersistService
{
    private String url;

    private String username;

    private String password;

    private ThreadLocal<Session> sessions;

    private SessionFactory sessionFactory;

    Neo4jPersistService()
    {
        sessions = new ThreadLocal<>();
    }

    @Inject
    Neo4jPersistService(@Named("neo4j.ogm.url") String url,
                        @Named("neo4j.ogm.username") String username,
                        @Named("neo4j.ogm.password") String password,
                        @Named("neo4j.ogm.packages") String[] packages)
    {
        this();
        this.url = url;
        this.username = username;
        this.password = password;
        this.sessionFactory = new SessionFactory(packages);
    }

    @Override
    public Session get()
    {
        if (!isWorking())
        {
            begin();
        }

        Session session = sessions.get();

        if (session == null)
        {
            throw new IllegalStateException("Requested Session outside work unit. " +
                                            "Try calling UnitOfWork.begin() first, or use a PersistFilter if you " +
                                            "are inside a servlet environment.");
        }

        return session;
    }

    boolean isWorking()
    {
        return sessions.get() != null;
    }


    @Override
    public void start()
    {
        // Do nothing...
    }

    @Override
    public void stop()
    {
        // Do nothing...
    }

    @Override
    public void begin()
    {
        if (sessions.get() != null)
        {
            throw new IllegalStateException("Work already begun on this thread. Looks like you have called UnitOfWork.begin() twice" +
                                            " without a balancing call to end() in between.");
        }

        sessions.set(sessionFactory.openSession(url, username, password));
    }

    @Override
    public void end()
    {
        Session session = sessions.get();

        // Let's not penalize users for calling end() multiple times.
        if (session == null)
        {
            return;
        }

        //session.close();
        sessions.remove();
    }
}
