package com.example.demo.service;

import com.example.demo.entity.Url;
import com.example.demo.repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class UrlService {
    private UrlRepository urlRepository;

    private final Map<String, String> urlMap = new HashMap<>();
    private final String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final Random random = new Random();
    private final String domain = "https://short.ly";

    // 1. Shorten the URL
    public String shortenURL(String longURL) {
        String shortCode = generateRandomCode();

        // Ensure no duplicate code (collision check)
        while (urlMap.containsKey(shortCode)) {
            shortCode = generateRandomCode();
        }

        urlMap.put(shortCode, longURL);
        String shortenedUrl=domain + shortCode;
        Url url=new Url();
        url.setOriginal_url(longURL);
        url.setShortened_url(shortenedUrl);
        urlRepository.save(url);
        return shortenedUrl;
    }

    // 2. Resolve/Expand the short URL
    public String getOriginalURL(String shortURL) {
        String code = shortURL.replace(domain, "");
        return urlMap.getOrDefault(code, "URL not found");
    }

    // Generate a 6-character random string
    private String generateRandomCode() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }


    public UrlService(UrlRepository urlRepository){
        this.urlRepository=urlRepository;
    }

}
