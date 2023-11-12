package com.egustore.eshop.mapper;


import com.egustore.eshop.dto.AddressDTO;
import com.egustore.eshop.dto.OriginDTO;
import com.egustore.eshop.model.Address;
import com.egustore.eshop.model.Origins;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
    Address mapToAddress(AddressDTO addressDTO);
    AddressDTO mapToAddressDto(Address address );
    @Mapping(target = "id", ignore = true)
    void updateAddressFromDTO(AddressDTO addressDTO, @MappingTarget Address address);
}
