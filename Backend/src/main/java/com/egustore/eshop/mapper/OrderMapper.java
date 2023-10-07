package com.egustore.eshop.mapper;

import com.egustore.eshop.dto.OrderDTO;
import com.egustore.eshop.entity.Order;

import java.util.List;

public interface OrderMapper {
    Order toEntity(OrderDTO orderDTO);
    OrderDTO toDTO (Order order);
    List<OrderDTO> toDTOList(List<Order> orders);
}
