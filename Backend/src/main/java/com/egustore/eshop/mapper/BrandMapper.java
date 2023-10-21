package com.egustore.eshop.mapper;


import com.egustore.eshop.dto.BrandDTO;
import com.egustore.eshop.dto.OriginDTO;
import com.egustore.eshop.model.Brand;
import com.egustore.eshop.model.Origins;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);
    Brand mapToBrand(BrandDTO brandDTO);
    BrandDTO mapToBrandDtoDto(Brand brand );
    @Mapping(target = "id", ignore = true)
    void updateBrandFromDTO(BrandDTO brandDTO, @MappingTarget Brand brand);
}
