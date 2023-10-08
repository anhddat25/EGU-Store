package com.egustore.eshop.mapper;

import com.egustore.eshop.dto.CategoryDTO;
import com.egustore.eshop.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    Category mapToCategory(CategoryDTO categoryDTO);
    CategoryDTO mapToCategoryDTO(Category category);
    @Mapping(target = "id", ignore = true)
    void updateCategoryFromDTO(CategoryDTO categoryDTO, @MappingTarget Category category);

}


