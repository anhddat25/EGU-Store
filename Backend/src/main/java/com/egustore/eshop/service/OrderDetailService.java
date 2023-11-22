package com.egustore.eshop.service;

import com.egustore.eshop.dto.OrderDTO;
import com.egustore.eshop.dto.OrderDetailDTO;
import com.egustore.eshop.model.Order;
import com.egustore.eshop.model.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    OrderDetail createOrderDetail(OrderDetailDTO orderDetailDTO);
    OrderDetail getOrderDetailById(int id);
    List<OrderDetailDTO> getOrderDetailByOrderID(Integer id);
    List<OrderDetail> getAllOrderDetails();
//    Integer updateOrderDetail(int id, OrderDetailDTO orderDetailDTO);
    Integer updateQuantityDetail(OrderDetailDTO orderDetailDTO, int id);
    void deleteOrderDetail(int id);
}