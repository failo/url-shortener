package com.staccato.shortener.casssandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

//bare bones for a cassandra connection
@Repository //using repository only for exception handling
public class CassandraConnection {

    private Cluster cluster;
    private Session session;

    @Autowired
    public CassandraConnection(@Value("${cassandra.connection.address}") String address,
                               @Value("${cassandra.connection.keyspace}") String keyspace,
                               @Value("${cassandra.connection.port}") int port){
        cluster = Cluster.builder()
                .withoutJMXReporting()
                .addContactPoint(address)
                .withPort(port)
                .build();
        session = cluster.connect(keyspace);
    }

    public void insert(String key, String value){
        session.execute(String.format(Statements.INSERT, key, value));
    }

    public String select(String key){
        String result = "";

        Row row = session.execute(String.format(Statements.SELECT, key)).one();
        result = row.getString("url");
        return result;
    }

}
