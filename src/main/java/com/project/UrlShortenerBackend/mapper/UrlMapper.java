package com.project.UrlShortenerBackend.mapper;

import com.project.UrlShortenerBackend.dto.CreateUrlDTO;
import com.project.UrlShortenerBackend.dto.ResponseUrlDTO;
import com.project.UrlShortenerBackend.model.ShortUrl;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UrlMapper {
    ResponseUrlDTO toDTO(ShortUrl shortUrl);
    CreateUrlDTO toEntity(CreateUrlDTO createUrlDTO);
}
