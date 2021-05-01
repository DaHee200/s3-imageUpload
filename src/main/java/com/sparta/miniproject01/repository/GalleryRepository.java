package com.sparta.miniproject01.repository;

import com.sparta.miniproject01.entity.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleryRepository extends JpaRepository<Gallery, Long> {
}
