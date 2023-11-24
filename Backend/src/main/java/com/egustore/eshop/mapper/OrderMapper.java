package com.egustore.eshop.mapper;

import com.egustore.eshop.dto.OrderDTO;
import com.egustore.eshop.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order toEntity(OrderDTO orderDTO);
//    @Mapping(source = "address.id", target = "addressId")
    @Mapping(source = "customer.id", target = "customerId")
//    @Mapping(source = "orderdetail.id", target = "orderdetailId")
    OrderDTO toDTO (Order order);
    @Mapping(target = "id", ignore = true)
    void updateOrderFromDTO(OrderDTO orderDTO, @MappingTarget Order order);

//    List<OrderDTO> toDTOList(List<Order> orders);

}
