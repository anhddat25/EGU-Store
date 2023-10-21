package com.egustore.eshop.service;

import com.egustore.eshop.dto.OrderDTO;
import com.egustore.eshop.model.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(OrderDTO orderDTO);

    Order getOrderById(int id);

    List<Order> getAllOrders();

    Order updateOrder(int id, OrderDTO orderDTO);

    void deleteOrder(int id);
}
