package com.project.UrlShortenerBackend.controller;

import com.project.UrlShortenerBackend.model.ShortUrl;
import com.project.UrlShortenerBackend.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class RedirectController {
    private final UrlService urlService;

    @GetMapping("/{code}")
    public ResponseEntity<Void> redirect(@PathVariable String code){
        ShortUrl url = urlService.getByCode(code);
        url.setAccessCount((url.getAccessCount()+1));
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(url.getOriginalUrl())).build();

    }
}
