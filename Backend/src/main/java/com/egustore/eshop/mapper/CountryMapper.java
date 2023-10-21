package com.egustore.eshop.mapper;


import com.egustore.eshop.dto.CountryDTO;
import com.egustore.eshop.dto.OriginDTO;
import com.egustore.eshop.model.Country;
import com.egustore.eshop.model.Origins;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);
    Country mapToCountry(CountryDTO countryDTO);
    CountryDTO mapToCountryDtoDto(Country country );
    @Mapping(target = "id", ignore = true)
    void updateCountryFromDTO(CountryDTO countryDTO, @MappingTarget Country country);
}
