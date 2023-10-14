package com.egustore.eshop.mapper;

import com.egustore.eshop.dto.ImageDTO;
import com.egustore.eshop.model.Images;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface ImageMapper {
    ImageMapper INSTANCE = Mappers.getMapper(ImageMapper.class);
    Images mapToImages(ImageDTO imageDTO);
    ImageDTO mapToImageDto(Images images );
    @Mapping(target = "id", ignore = true)
    void updateImageFromDTO(ImageDTO imageDTO, @MappingTarget Images images);
}
