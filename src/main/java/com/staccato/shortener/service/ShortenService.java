package com.staccato.shortener.service;

import com.staccato.shortener.casssandra.CassandraConnection;
import com.staccato.shortener.keys.KeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URL;

@Service
public class ShortenService {

    private static int URL_MAX_LENGTH = 2048;

    @Value("${staccato.shortener.keyLength}")
    private int keyLength;

    @Autowired
    CassandraConnection cass;

    public String generateUrl(String url){
        url = addPrefix(url);
        validateUrl(url);
        String key = KeyGenerator.generateKeys(keyLength).get(0);
        cass.insert(key, url);

        return key;
    }

    public String getUrl(String key){
        return cass.select(key);
    }

    public String getFormattedUrl(String url, String hostname, int port){
        if(port != 80 || port != 443){
            hostname = hostname + ":" + port;
        }
        return hostname + "/" + url;

    }

    private void validateUrl(String url){
        validateLength(url);
        try{
            URL u = new URL(url);
            u.toURI();
        }catch (Exception e){
            throw new IllegalArgumentException("Invalid URL");
        }
    }

    private void validateLength(String url){
        if(url.length() > URL_MAX_LENGTH){
            throw new IllegalArgumentException("Url is larger than RFC standards");
        }
    }

    private String addPrefix(String url){
        if(!url.contains("://")){
            url = "http://" + url;
        }
        return url;
    }
}
