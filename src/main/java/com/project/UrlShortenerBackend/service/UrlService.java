package com.project.UrlShortenerBackend.service;

import com.project.UrlShortenerBackend.model.ShortUrl;
import com.project.UrlShortenerBackend.repository.UrlRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.security.SecureRandom;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class UrlService {
    private static final String BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final UrlRepository urlRepository;
    public ShortUrl createShortUrl(String originalUrl){
        String code;
        code=generateCode(10);
        while(urlRepository.existsByShortCode(code)){
            code= generateCode(10);
        }
        ShortUrl shortUrl= new ShortUrl();
        shortUrl.setOriginalUrl(originalUrl);
        shortUrl.setShortUrl(code);
        shortUrl.setCreatedAt(LocalDateTime.now());

        return urlRepository.save(shortUrl);

    }

    public ShortUrl getByCode(String code){
        return urlRepository.findByShortCode(code).orElseThrow(()-> new RuntimeException("URL not found"));
    }

    public String generateCode(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(BASE62.charAt(random.nextInt(BASE62.length())));
        }
        return sb.toString();
    }

}
