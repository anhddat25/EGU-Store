package com.egustore.eshop.mapper;

import com.egustore.eshop.dto.CustomerDTO;
import com.egustore.eshop.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    Customer mapToCustomer(CustomerDTO customerDTO);
    CustomerDTO mapToCustomerDto(Customer customer);
    @Mapping(target = "id", ignore = true)
    void updateCustomerFromDTO(CustomerDTO customerDTO, @MappingTarget Customer customer);
}
