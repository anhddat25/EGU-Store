package com.egustore.eshop.mapper;

import com.egustore.eshop.dto.CategoryDTO;
import com.egustore.eshop.dto.FeedbackProductDTO;
import com.egustore.eshop.model.Category;
import com.egustore.eshop.model.FeedbackProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface FeedbackProductMapper {
    FeedbackProductMapper INSTANCE = Mappers.getMapper(FeedbackProductMapper.class);
    FeedbackProduct mapToEntity(FeedbackProductDTO dto);
    FeedbackProductDTO mapToDTO(FeedbackProduct entity);
    @Mapping(target = "id", ignore = true)
    void updateFeedbackFromDTO(FeedbackProductDTO dto, @MappingTarget FeedbackProduct entity);
}