package com.egustore.eshop.service;

import com.egustore.eshop.dto.ImageDTO;
import com.egustore.eshop.model.Images;

import java.util.List;

public interface ImageService {
    Images createImage(ImageDTO imageDTO);

    Images getImageById(int id);

    List<Images> getAllImages();

    Images updateImage(int id,
                       ImageDTO imageDTO);

    void deleteImage(int id);
}
