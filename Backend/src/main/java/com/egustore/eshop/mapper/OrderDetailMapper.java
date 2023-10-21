package com.egustore.eshop.mapper;

import com.egustore.eshop.dto.OrderDetailDTO;
import com.egustore.eshop.model.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderDetailMapper {

    OrderDetailMapper INSTANCE = Mappers.getMapper(OrderDetailMapper.class);
    OrderDetail mapToOrderDetail(OrderDetailDTO orderDetailDTO);
    OrderDetailDTO mapToOrderDetailDto(OrderDetail orderDetail);
    @Mapping(target = "id", ignore = true)
    void updateOrderDetailFromDTO(OrderDetailDTO orderDetailDTO, @MappingTarget OrderDetail orderDetail);
}
