package com.staccato.shortener.controller;

import com.staccato.shortener.model.UrlMapping;
import com.staccato.shortener.service.ShortenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ShortenController {

    @Autowired
    ShortenService shorten;

    @GetMapping
    @RequestMapping(value = "/*")
    public final ResponseEntity redirectMapping(HttpServletRequest request){
        String redirected = shorten.getUrl(request.getRequestURI().substring(1));
        return new ResponseEntity<>(getRedirectHeaders(redirected), HttpStatus.SEE_OTHER);
    }

    @PutMapping
    @RequestMapping(value="/mapping")
    public final ResponseEntity createMapping(@RequestBody UrlMapping mapping, HttpServletRequest request){
        //register on DB
        String shortLink = shorten.generateUrl(mapping.getUrl());
        String redirected = shorten.getFormattedUrl(shortLink, request.getServerName(), request.getServerPort());
        return new ResponseEntity<>(redirected, HttpStatus.OK);
    }

    private HttpHeaders getRedirectHeaders(String url){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", url);
        return headers;
    }
}
