package com.egustore.eshop.serviceimpl;

import com.egustore.eshop.dto.ImageDTO;
import com.egustore.eshop.enums.ImageStatus;
import com.egustore.eshop.mapper.ImageMapper;
import com.egustore.eshop.model.Images;
import com.egustore.eshop.model.Product;
import com.egustore.eshop.repository.ImageRepository;
import com.egustore.eshop.service.ImageService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;
    private final ImageMapper imageMapper;

    private final GoogleDriveApiService googleDriveApiService;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository, ImageMapper imageMapper, GoogleDriveApiService googleDriveApiService, GoogleDriveApiService googleDriveApiService1)
    {
        this.imageRepository = imageRepository;
        this.imageMapper = imageMapper;
        this.googleDriveApiService = googleDriveApiService1;
    }

//    @Override
//    public Images createImage(ImageDTO imageDTO) {
//        Images image = imageMapper.mapToImages(imageDTO);
//        return imageRepository.save(image);
//    }

    @Override
    public Images getImageById(int id){
        return imageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Image not found"));
    }



    @Override
    public List<Images> getAllImages() {
        return imageRepository.findAll();
    }

    @Override
    public List<Images> getByProductId(int id) {
        return imageRepository.findByProductId(id);
    }

    @Override
    public Images updateImage(int id,ImageDTO imageDTO) {
        Images existImage = getImageById(id);
        imageMapper.updateImageFromDTO(imageDTO, existImage);
        imageRepository.save(existImage);
        return existImage;
    }

    @Override
    public Images updateImageUrl(int Id, MultipartFile files, ImageStatus status) throws IOException {
        Optional<Images> existingImages = imageRepository.findById(Id);

        if (existingImages.isPresent()) {
            // Update the image in Google Drive
            String folderId = "19ZF5ZY7MZ0TdnFfMsOZrZS6unc1YEkxk";
            String imageUrl = googleDriveApiService.uploadImageToGoogleDrive(files, folderId);

            // Update the image URL in the database
            Images existingEntity = existingImages.get();
            existingEntity.setImageUrl(imageUrl);
            existingEntity.setImageStatus(status);
            existingEntity.setUpdateDate(new Date());
            return imageRepository.save(existingEntity);
        } else {
            // Handle the case where the entity with the given ID does not exist
            throw new EntityNotFoundException("Entity with ID " + Id + " not found");
        }
    }

    @Override
    public void deleteImage(int id) {

        imageRepository.deleteById(id);
    }



    @Override
    public String uploadImageToGoogleDrive(MultipartFile files, Product productId, ImageStatus status) throws IOException {
        String folderId = "19ZF5ZY7MZ0TdnFfMsOZrZS6unc1YEkxk"; // Thay thế bằng ID của thư mục cần

        String imageUrl = googleDriveApiService.uploadImageToGoogleDrive(files, folderId);
                // Create a new Images instance to save to the database
                Images fileData = new Images();
                fileData.setTitle(files.getOriginalFilename());
                fileData.setImageUrl(imageUrl);
                fileData.setCreateDate(new Date()); // You might want to set the creation date
                fileData.setImageStatus(status);
                fileData.setUpdateDate(new Date());
                fileData.setProducts(productId);
                Images savedImage = imageRepository.save(fileData);
                if (savedImage != null) {
                    return "File uploaded successfully. Image ID: " + fileData.getId();
                }

        return null;
    }
}
