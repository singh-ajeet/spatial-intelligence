package com.si.platform.cassandra;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.si.platform.cassandra.CassandraConfiguration.getCassandraConfiguration;

/**
 * This factor class craete an singleton object of <code>CqlSession</code>
 */
public final class CqlSessionFactory {
    private static Logger LOG = LoggerFactory.getLogger(CqlSessionFactory.class);
    private static final String VERSION_CQL = "SELECT release_version FROM system.local";

    private CqlSessionFactory(){
        //To block reflection API
        throw new IllegalStateException("CqlSessionFactory is not instantiable !!");
    }

    public static CqlSession getSession(){
        return SessionHolder.CQL_SESSION;
    }

    private static class SessionHolder {
        private static final Supplier<CassandraConfiguration> CASSANDRA_CONFIGURATION_SUPPLIER
                = Suppliers.memoize(() -> getCassandraConfiguration());
        private static final CqlSession CQL_SESSION = buildAndTestSession();

        private static CqlSession buildAndTestSession(){
            CqlSession cqlSession = buildSession();
            testSession(cqlSession);

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                LOG.info("Shutting down cassandra cluster session.");
                cqlSession.close();
            }));

            return cqlSession;
        }

        private static CqlSession buildSession(){
            CassandraConfiguration config = CASSANDRA_CONFIGURATION_SUPPLIER.get();
            return  CqlSession.builder()
                    .addContactPoints(config.getContactPoints())
                    .withLocalDatacenter(config.getDataCenter())
                    .withKeyspace(config.getKeyspace())
                    .build();
        }

        private static void testSession(CqlSession cqlSession) {
            ResultSet rs = getSession().execute(VERSION_CQL);
            Row row = rs.one();
            LOG.info("Cassandra cluster " + row.getString("release_version") +  " cql session successfully created.");
        }
    }
}
