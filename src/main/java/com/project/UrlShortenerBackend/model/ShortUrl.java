package com.project.UrlShortenerBackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Entity
@Table(name = "short_urls")
public class ShortUrl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 2048)
    private String originalUrl;
    @Column(nullable = false, unique = true, length = 10)
    private String shortUrl;
    private LocalDateTime createdAt;
    private Long accessCount = 0L;
}
