package com.egustore.eshop.mapper;

import com.egustore.eshop.dto.OrderDetailDTO;
import com.egustore.eshop.entity.Order;
import com.egustore.eshop.entity.OrderDetail;

import java.util.List;

public interface OrderDetailMapper {
    OrderDetail toEntity(OrderDetailDTO orderDetailDTO);
    OrderDetailDTO toDTO(OrderDetail orderDetail);
    List<OrderDetailDTO> toDTOList(List<OrderDetail> orderDetails);
}
