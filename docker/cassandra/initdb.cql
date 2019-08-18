CREATE KEYSPACE IF NOT EXISTS shortener WITH replication =
{'class':'SimpleStrategy','replication_factor':'1'};


CREATE TABLE IF NOT EXISTS shortener.mapping (search_hash text, url text, PRIMARY KEY (search_hash));