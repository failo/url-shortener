FROM cassandra

COPY initdb.cql /initdb.cql
COPY init-schema.sh /init-schema.sh
ENTRYPOINT ["/init-schema.sh"]
CMD ["cassandra", "-f"]

