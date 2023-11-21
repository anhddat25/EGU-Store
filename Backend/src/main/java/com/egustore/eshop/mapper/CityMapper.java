package com.egustore.eshop.mapper;


import com.egustore.eshop.dto.CityDTO;
import com.egustore.eshop.dto.OriginDTO;
import com.egustore.eshop.model.City;
import com.egustore.eshop.model.Origin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);
    City mapToCity(CityDTO cityDTO);
    CityDTO mapToCityDtoDto(City city );
    @Mapping(target = "id", ignore = true)
    void updateCityFromDTO(CityDTO cityDTO, @MappingTarget City city);
}
