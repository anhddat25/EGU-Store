package com.egustore.eshop.mapper;

import com.egustore.eshop.dto.BrandDTO;
import com.egustore.eshop.model.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface BrandMapper {
    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);
    BrandDTO mapToBrandDTO(Brand brand);

    Brand mapToBrand(BrandDTO dto);

    @Mapping(target = "id", ignore = true)
    void updateBrandFromDTO(BrandDTO dto, @MappingTarget Brand entity);
}
