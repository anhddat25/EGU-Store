package com.egustore.eshop.mapper;

import com.egustore.eshop.dto.OrderDTO;
import com.egustore.eshop.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

//    @Mapping(source = "orderId",target = "id")
//    @Mapping(source = "orderEmail", target = "email")
//    @Mapping(source = "orderPhone", target = "phone")
//    @Mapping(source = "orderDate", target = "orderDate")
//    @Mapping(source = "orderNote", target = "note")
//    @Mapping(source = "orderStatus", target = "status")
//    @Mapping(source = "orderPaymentMethod", target = "paymentMethod")
//    @Mapping(source = "orderDiscountPrice", target = "discountPrice")
//    @Mapping(source = "orderCustomerId", target = "customerId")
    Order toEntity(OrderDTO orderDTO);

//    @Mapping(source = "id",target = "orderId")
//    @Mapping(source = "id", target = "orderId")
//    @Mapping(source = "email", target = "orderEmail")
//    @Mapping(source = "phone", target = "orderPhone")
//    @Mapping(source = "orderDate", target = "orderDate")
//    @Mapping(source = "note", target = "orderNote")
//    @Mapping(source = "status", target = "orderStatus")
//    @Mapping(source = "paymentMethod", target = "orderPaymentMethod")
//    @Mapping(source = "discountPrice", target = "orderDiscountPrice")
//    @Mapping(source = "customerId", target = "orderCustomerId")
    OrderDTO toDTO (Order order);
    List<OrderDTO> toDTOList(List<Order> orders);
}
