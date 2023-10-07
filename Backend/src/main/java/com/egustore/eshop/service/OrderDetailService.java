package com.egustore.eshop.service;

import com.egustore.eshop.dto.OrderDTO;
import com.egustore.eshop.dto.OrderDetailDTO;
import com.egustore.eshop.entity.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    OrderDetail saveOrder(OrderDetailDTO orderDetailDTO);
    OrderDetailDTO getOrderDetailById(int id);
    List<OrderDetailDTO> getOrderDetailList();
}
