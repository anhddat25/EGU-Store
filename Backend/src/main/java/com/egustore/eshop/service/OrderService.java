package com.egustore.eshop.service;

import com.egustore.eshop.dto.OrderDTO;
import com.egustore.eshop.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderService {
    Order saveOrder(OrderDTO orderDTO);
    OrderDTO getOrderById(int id);
    List<OrderDTO> getOrderList();

//    Order saveOrder1(Order order);
//    OrderDTO getOrderById1(int id);
}
