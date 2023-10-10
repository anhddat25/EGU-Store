package com.egustore.eshop.mapper;


import com.egustore.eshop.dto.SpecificationsDTO;
import com.egustore.eshop.model.Specifications;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SpecificationsMapper {
    SpecificationsMapper INSTANCE = Mappers.getMapper(SpecificationsMapper.class);
    Specifications mapToSpec(SpecificationsDTO specificationsDTO);
    SpecificationsDTO mapToSpecDTO(Specifications specifications);
    @Mapping(target = "id", ignore = true)
    void updateSpecFromDTO(SpecificationsDTO specificationsDTO, @MappingTarget Specifications specifications);
}
