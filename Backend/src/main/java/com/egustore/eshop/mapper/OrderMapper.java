package com.egustore.eshop.mapper;

import com.egustore.eshop.dto.OrderDTO;
import com.egustore.eshop.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    Order mapToOrder(OrderDTO orderDTO);
    OrderDTO mapToOrderDto(Order order);
    @Mapping(target = "id", ignore = true)
    void updateOrderFromDTO(OrderDTO orderDTO, @MappingTarget Order order);
}
