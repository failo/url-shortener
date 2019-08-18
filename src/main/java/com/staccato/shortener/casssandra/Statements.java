package com.staccato.shortener.casssandra;

public class Statements {

    public static final String INSERT = "INSERT INTO mapping (search_hash, url) VALUES ('%s', '%s')";

    public static final String SELECT = "SELECT url FROM mapping WHERE search_hash='%s'";
}
