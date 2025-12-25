package com.project.UrlShortenerBackend.controller;

import com.project.UrlShortenerBackend.dto.CreateUrlDTO;
import com.project.UrlShortenerBackend.dto.ResponseUrlDTO;
import com.project.UrlShortenerBackend.model.ShortUrl;
import com.project.UrlShortenerBackend.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequiredArgsConstructor
@RestController
 @RequestMapping("/api/urls")
public class UrlController {
    private final UrlService urlService;

    @PostMapping
    public ResponseUrlDTO create(@RequestBody CreateUrlDTO createUrlDTO){
        ShortUrl shortUrl= urlService.createShortUrl(createUrlDTO.getOriginalUrl());
        return new ResponseUrlDTO("http://localhost:8080/" + shortUrl.getShortUrl(),0L);
    }
    @GetMapping("/{code}")
    public ResponseEntity<Void> redirect(@PathVariable String code){
        ShortUrl url = urlService.getByCode(code);
        url.setAccessCount(url.getAccessCount()+1);
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(url.getOriginalUrl())).build();
    }




}
