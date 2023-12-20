package com.egustore.eshop.repository;

import com.egustore.eshop.model.Images;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Images, Integer> {
    List<Images> findByProductId(int products);
}
