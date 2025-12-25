package com.project.UrlShortenerBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseUrlDTO {
    private String shortCode;
    private Long accessCount;
}
