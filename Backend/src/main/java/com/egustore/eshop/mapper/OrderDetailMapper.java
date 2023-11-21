package com.egustore.eshop.mapper;

import com.egustore.eshop.dto.OrderDetailDTO;
import com.egustore.eshop.model.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(componentModel = "spring")
public interface OrderDetailMapper {
    OrderDetailMapper INSTANCE = Mappers.getMapper(OrderDetailMapper.class);

    OrderDetail toEntity(OrderDetailDTO orderDetailDTO);
    @Mappings({
            @Mapping(source = "product.id", target = "productId"),
            @Mapping(source = "order.id", target = "orderId")})
    OrderDetailDTO toDTO(OrderDetail orderDetail);

    List<OrderDetailDTO> toDTOList(List<OrderDetail> orderDetails);
}