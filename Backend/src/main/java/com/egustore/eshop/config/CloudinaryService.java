package com.egustore.eshop.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryService {
    private final Cloudinary cloudinary;

    public CloudinaryService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    public Map<String, String> upload(MultipartFile file) {
        try {
            byte[] fileBytes = file.getBytes();
            return this.cloudinary.uploader().upload(fileBytes, ObjectUtils.emptyMap());
        } catch (IOException e) {
            // Handle the IOException when reading file bytes
            throw new RuntimeException("Failed to read file bytes: " + e.getMessage(), e);
        } catch (Exception e) {
            // Handle other exceptions, including CloudinaryException
            throw new RuntimeException("Image upload failed: " + e.getMessage(), e);
        }
    }
}
