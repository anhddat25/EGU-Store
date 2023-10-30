package com.egustore.eshop.service;

import com.egustore.eshop.dto.OrderDTO;
import com.egustore.eshop.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> saveOrders(List<OrderDTO> orderDTOList);
    Order getOrderById(int id);
    List<Order> getAllOrders();

//    Integer updateOrder(int id, OrderDTO orderDTO);
    void deleteOrder(int id);
}
