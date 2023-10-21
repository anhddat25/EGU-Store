package com.egustore.eshop.serviceimpl;


import com.egustore.eshop.dto.OrderDetailDTO;
import com.egustore.eshop.mapper.OrderDetailMapper;
import com.egustore.eshop.model.OrderDetail;
import com.egustore.eshop.repository.OrderDetailRepository;
import com.egustore.eshop.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;
    private final OrderDetailMapper orderDetailMapper;

    @Autowired
    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository, OrderDetailMapper orderDetailMapper)
    {
        this.orderDetailRepository = orderDetailRepository;
        this.orderDetailMapper = orderDetailMapper;
    }

    @Override
    public OrderDetail createOrderDetail(OrderDetailDTO orderDetailDTO) {
        OrderDetail orderDetail = orderDetailMapper.mapToOrderDetail(orderDetailDTO);
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public OrderDetail getOrderDetailById(int id){
        return orderDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderDetail not found"));
    }



    @Override
    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailRepository.findAll();
    }

    @Override
    public OrderDetail updateOrderDetail(int id,
                                   OrderDetailDTO orderDetailDTO) {
        OrderDetail existOrderDetail = getOrderDetailById(id);
        orderDetailMapper.updateOrderDetailFromDTO(orderDetailDTO, existOrderDetail);
        orderDetailRepository.save(existOrderDetail);
        return existOrderDetail;
    }

    @Override
    public void deleteOrderDetail(int id) {

        orderDetailRepository.deleteById(id);
    }

}
