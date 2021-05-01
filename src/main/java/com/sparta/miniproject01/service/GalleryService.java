package com.sparta.miniproject01.service;

import com.sparta.miniproject01.dto.GalleryDto;
import com.sparta.miniproject01.repository.GalleryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

//db에 저장하는 로직
@Service
@AllArgsConstructor
public class GalleryService {
    private GalleryRepository galleryRepository;

    public void savePost(GalleryDto galleryDto) {
        galleryRepository.save(galleryDto.toEntity());
    }
}