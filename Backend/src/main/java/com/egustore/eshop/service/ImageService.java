package com.egustore.eshop.service;

import com.egustore.eshop.dto.ImageDTO;
import com.egustore.eshop.enums.ImageStatus;
import com.egustore.eshop.model.Images;
import com.egustore.eshop.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface ImageService {
//    Images createImage(ImageDTO imageDTO);

    Images getImageById(int id);

    List<Images> getAllImages();

    Images updateImage(int id,
                       ImageDTO imageDTO);

    Images updateImageUrl(int Id, MultipartFile files, ImageStatus status) throws IOException;

    void deleteImage(int id);


    String uploadImageToGoogleDrive(MultipartFile files, Product productId, ImageStatus status) throws IOException;
}
