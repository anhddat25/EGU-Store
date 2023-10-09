package com.egustore.eshop.mapper;

import com.egustore.eshop.dto.OrderDetailDTO;
import com.egustore.eshop.model.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(componentModel = "spring")
public interface OrderDetailMapper {
    OrderDetailMapper INSTANCE = Mappers.getMapper(OrderDetailMapper.class);

//    @Mapping(source = "quantity",target = "quantity")
    @Mapping(source = "id", target = "id")
//    @Mapping(source = "totalPrice", target = "totalPrice")
//    @Mapping(source = "orderId", target = "orderId")
//    @Mapping(source = "productId", target = "productId")
    OrderDetail toEntity(OrderDetailDTO orderDetailDTO);

//    @Mapping(source = "quantity",target = "quantity")
    @Mapping(source = "id", target = "id")
//    @Mapping(source = "totalPrice", target = "totalPrice")
//    @Mapping(source = "orderId", target = "orderId")
//    @Mapping(source = "productId", target = "productId")
    OrderDetailDTO toDTO(OrderDetail orderDetail);
    List<OrderDetailDTO> toDTOList(List<OrderDetail> orderDetails);
}
