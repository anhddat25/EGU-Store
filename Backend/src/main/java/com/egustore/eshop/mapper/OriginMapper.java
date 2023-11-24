package com.egustore.eshop.mapper;


import com.egustore.eshop.dto.OriginDTO;
import com.egustore.eshop.model.Origin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OriginMapper {
    OriginMapper INSTANCE = Mappers.getMapper(OriginMapper.class);
    Origin mapToOrigins(OriginDTO originDTO);
    OriginDTO mapToOriginDto(Origin origin);
    @Mapping(target = "id", ignore = true)
    void updateOriginFromDTO(OriginDTO originDTO, @MappingTarget Origin origin);
}
