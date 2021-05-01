package com.sparta.miniproject01.controller;

import com.sparta.miniproject01.config.Const;
import com.sparta.miniproject01.dto.GalleryDto;
import com.sparta.miniproject01.service.GalleryService;
import com.sparta.miniproject01.service.S3Service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@AllArgsConstructor
@CrossOrigin(origins = Const.ClientServerHost)
public class GalleryController {

    private S3Service s3Service;
    private GalleryService galleryService;

    @GetMapping("/gallery")
    public String dispWrite() {

        return "/gallery";
    }

    @PostMapping("/gallery")
    public String execWrite(GalleryDto galleryDto, MultipartFile file) throws IOException {
        // AWS S3의 비즈니스 로직을 담당하며, 파일을 조작
        String imgPath = s3Service.upload(file);
        galleryDto.setFilePath(imgPath);


        //DB에 데이터를 조작하기 위한 서비스
        galleryService.savePost(galleryDto);

        return "redirect:/gallery";
    }
}