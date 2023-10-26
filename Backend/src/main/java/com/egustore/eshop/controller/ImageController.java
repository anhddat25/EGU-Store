package com.egustore.eshop.controller;

import com.egustore.eshop.dto.ImageDTO;
import com.egustore.eshop.model.Images;
import com.egustore.eshop.service.ImageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v0/images")
@Validated
@CrossOrigin("*")
public class ImageController {
    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }
    //Create images
    @PostMapping("/create")
    public ResponseEntity<?> createImages(@RequestBody @Valid ImageDTO imageDTO, BindingResult result)
    {
        if(result.hasErrors())
        {
            List<String> errMessage = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errMessage);
        }
        imageService.createImage(imageDTO);
        return ResponseEntity.ok("Create image successfully!");
    }

    //Show all image
    @GetMapping("/list")
    public ResponseEntity<List<Images>> getAllImages() {
        List<Images> images = imageService.getAllImages();
        return ResponseEntity.ok(images);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateImages(@PathVariable int id,@RequestBody ImageDTO imageDTO) {
        imageService.updateImage(id,imageDTO);
        return ResponseEntity.ok("update image ");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteImages(@PathVariable int id) {
        imageService.deleteImage(id);
        return ResponseEntity.ok("delete image " + id);
    }
}
