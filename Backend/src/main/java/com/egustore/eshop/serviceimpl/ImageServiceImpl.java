package com.egustore.eshop.serviceimpl;

import com.egustore.eshop.dto.ImageDTO;
import com.egustore.eshop.mapper.ImageMapper;
import com.egustore.eshop.model.Images;
import com.egustore.eshop.repository.ImageRepository;
import com.egustore.eshop.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;
    private final ImageMapper imageMapper;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository, ImageMapper imageMapper)
    {
        this.imageRepository = imageRepository;
        this.imageMapper = imageMapper;
    }

    @Override
    public Images createImage(ImageDTO imageDTO) {
        Images image = imageMapper.mapToImages(imageDTO);
        return imageRepository.save(image);
    }

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
    public Images updateImage(int id,
                                   ImageDTO imageDTO) {
        Images existImage = getImageById(id);
        imageMapper.updateImageFromDTO(imageDTO, existImage);
        imageRepository.save(existImage);
        return existImage;
    }

    @Override
    public void deleteImage(int id) {

        imageRepository.deleteById(id);
    }
}
