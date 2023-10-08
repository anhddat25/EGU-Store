package com.egustore.eshop.mapper;

import com.egustore.eshop.dto.OrderDetailDTO;
import com.egustore.eshop.model.OrderDetail;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface OrderDetailMapper {
    OrderDetail toEntity(OrderDetailDTO orderDetailDTO);
    OrderDetailDTO toDTO(OrderDetail orderDetail);
    List<OrderDetailDTO> toDTOList(List<OrderDetail> orderDetails);
}
