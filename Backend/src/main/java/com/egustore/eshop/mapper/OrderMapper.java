package com.egustore.eshop.mapper;

import com.egustore.eshop.dto.OrderDTO;
import com.egustore.eshop.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(source = "orderId",target = "id")
//    @Mapping(source = "EmailDTO", target = "Email")
//    @Mapping(source = "PhoneDTO", target = "Phone")
//    @Mapping(source = "orderDateDTO", target = "orderDate")
//    @Mapping(source = "NoteDTO", target = "Note")
//    @Mapping(source = "StatusDTO", target = "Status")
//    @Mapping(source = "paymentMethodDTO", target = "paymentMethod")
//    @Mapping(source = "discountPriceDTO", target = "discountPrice")
    Order toEntity(OrderDTO orderDTO);

    @Mapping(source = "id",target = "orderId")
//    @Mapping(source = "Email", target = "EmailDTO")
//    @Mapping(source = "Phone", target = "PhoneDTO")
//    @Mapping(source = "orderDate", target = "orderDateDTO")
//    @Mapping(source = "Note", target = "NoteDTO")
//    @Mapping(source = "Status", target = "StatusDTO")
//    @Mapping(source = "paymentMethod", target = "paymentMethodDTO")
//    @Mapping(source = "discountPrice", target = "discountPriceDTO")
//    @Mapping(source = "customerId", target = "customerIdDTO")
    OrderDTO toDTO (Order order);
    List<OrderDTO> toDTOList(List<Order> orders);
}
