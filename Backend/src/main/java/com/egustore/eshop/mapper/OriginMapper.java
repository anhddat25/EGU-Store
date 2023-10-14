package com.egustore.eshop.mapper;


import com.egustore.eshop.dto.OriginDTO;
import com.egustore.eshop.model.Origins;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OriginMapper {
    OriginMapper INSTANCE = Mappers.getMapper(OriginMapper.class);
    Origins mapToOrigins(OriginDTO originDTO);
    OriginDTO mapToOriginDto(Origins origins );
    @Mapping(target = "id", ignore = true)
    void updateOriginFromDTO(OriginDTO originDTO, @MappingTarget Origins origins);
}
