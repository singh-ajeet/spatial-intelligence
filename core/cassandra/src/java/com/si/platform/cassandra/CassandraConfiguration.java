package com.si.platform.cassandra;

import java.net.InetSocketAddress;
import java.util.Collection;

/**
 * To hold the congiguration properties to connect with a cassandra cluster
 */
public final class CassandraConfiguration {
    private final Collection<InetSocketAddress> contactPoints;
    private final String keyspace;
    private final String dataCenter;

    private CassandraConfiguration(Collection<InetSocketAddress> contactPoints, String keyspace, String dataCenter) {
        this.contactPoints = contactPoints;
        this.keyspace = keyspace;
        this.dataCenter = dataCenter;
    }

    public Collection<InetSocketAddress> getContactPoints() {
        return contactPoints;
    }

    public String getKeyspace() {
        return keyspace;
    }

    public String getDataCenter() {
        return dataCenter;
    }

    public static CassandraConfiguration getCassandraConfiguration() {
        return loadFromYaml();
    }

    private static CassandraConfiguration loadFromYaml() {
        throw new UnsupportedOperationException("This is in progress ...");
    }
}
