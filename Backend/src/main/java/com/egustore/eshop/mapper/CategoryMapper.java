package com.egustore.eshop.mapper;

import com.egustore.eshop.dto.CategoryDTO;
import com.egustore.eshop.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    @Mapping(source = "categoryId", target = "id")
    @Mapping(source = "categoryName", target = "name")
    Category formDTO(CategoryDTO categoryDTO);
    CategoryDTO toDTO(Category category);
}


