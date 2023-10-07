package com.egustore.eshop.service.serviceimp;

import com.egustore.eshop.dto.OrderDTO;
import com.egustore.eshop.dto.OrderDetailDTO;
import com.egustore.eshop.entity.OrderDetail;
import com.egustore.eshop.mapper.OrderDetailMapper;
import com.egustore.eshop.repository.OrderDetailRepository;
import com.egustore.eshop.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderDetailServiceImp implements OrderDetailService {
    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Autowired
    OrderDetailMapper orderDetailMapper;

    @Override
    public OrderDetail saveOrder(OrderDetailDTO orderDetailDTO) {
        return orderDetailRepository.save(orderDetailMapper.toEntity(orderDetailDTO));
    }

    @Override
    public OrderDetailDTO getOrderDetailById(int id) {
        return orderDetailRepository.findById(id)
                .map(orderDetailMapper::toDTO)
                .orElse(new OrderDetailDTO());
    }

    @Override
    public List<OrderDetailDTO> getOrderDetailList() {
        return orderDetailMapper.toDTOList(orderDetailRepository.findAll());
    }
}
