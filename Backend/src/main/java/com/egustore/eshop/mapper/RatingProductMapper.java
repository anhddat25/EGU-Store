package com.egustore.eshop.mapper;

import com.egustore.eshop.dto.RatingProductDTO;
import com.egustore.eshop.model.RatingProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface RatingProductMapper {
    RatingProductMapper INSTANCE = Mappers.getMapper(RatingProductMapper.class);
    RatingProductDTO mapToDto(RatingProduct entity);

    RatingProduct mapToEntity(RatingProductDTO dto);

    @Mapping(target = "id", ignore = true)
    void updateRatingFromDTO(RatingProductDTO dto, @MappingTarget RatingProduct entity);
}