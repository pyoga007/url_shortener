package com.example.demo.controller;

import com.example.demo.service.UrlService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UrlController {

    private UrlService urlService;

    public UrlController(UrlService urlService){
        this.urlService=urlService;
    }

    @PostMapping("/url-shortener")
    public String urlShortener(@RequestBody String url){
        String shortenedUrl=urlService.shortenURL(url);
        return shortenedUrl;
    }
}
