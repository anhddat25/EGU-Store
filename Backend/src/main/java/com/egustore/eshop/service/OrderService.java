package com.egustore.eshop.service;

import com.egustore.eshop.dto.OrderDTO;
import com.egustore.eshop.model.Order;

import java.util.List;

public interface OrderService {
    Order saveOrder(OrderDTO orderDTO);
    Order getOrderById(int id);
    List<Order> getAllOrders();

//    Integer updateOrder(int id, OrderDTO orderDTO);
    void deleteOrder(int id);


//    Order saveOrder1(Order order);
//    OrderDTO getOrderById1(int id);
}
