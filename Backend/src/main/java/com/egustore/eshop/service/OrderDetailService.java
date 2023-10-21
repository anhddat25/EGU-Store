package com.egustore.eshop.service;

import com.egustore.eshop.dto.OrderDetailDTO;
import com.egustore.eshop.model.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    OrderDetail createOrderDetail(OrderDetailDTO orderDetailDTO);

    OrderDetail getOrderDetailById(int id);

    List<OrderDetail> getAllOrderDetails();

    OrderDetail updateOrderDetail(int id, OrderDetailDTO orderDetailDTO);

    void deleteOrderDetail(int id);
}
