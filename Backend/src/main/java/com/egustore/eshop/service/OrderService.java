package com.egustore.eshop.service;

import com.egustore.eshop.dto.OrderDTO;
import com.egustore.eshop.dto.ProductDTO;
import com.egustore.eshop.model.Order;

import java.util.List;

public interface OrderService {
    Order saveOrder(OrderDTO orderDTO);
    Order getOrderById(int id);
    List<Order> getAllOrders();

    //    Integer updateOrder(int id, OrderDTO orderDTO);
    void deleteOrder(int id);
    Integer updateOrderById(OrderDTO orderDTO, int id);
//    void deleteOrder(int id);
//    Integer updateOrderById(OrderDTO orderDTO, int id);
    Integer updateOrderStatus(OrderDTO orderDTO, int id);
    Order updateOrder(int id, OrderDTO Order);

    List<Order> getOrderByCustomerId(int customerId);
//    Order saveOrder1(Order order);
//    OrderDTO getOrderById1(int id);
}