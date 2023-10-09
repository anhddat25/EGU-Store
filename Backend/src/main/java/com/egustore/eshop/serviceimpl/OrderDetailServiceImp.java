package com.egustore.eshop.serviceimpl;

import com.egustore.eshop.dto.OrderDetailDTO;
import com.egustore.eshop.model.OrderDetail;
import com.egustore.eshop.mapper.OrderDetailMapper;
import com.egustore.eshop.repository.OrderDetailRepository;
import com.egustore.eshop.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
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

    @Override
    public Integer updateOrderDetail(int id, OrderDetailDTO orderDetailDTO) {
        return orderDetailRepository.updateOrderDetailById(orderDetailDTO, id);
    }

    @Override
    public void deleteOrderDetail(int id) {
        orderDetailRepository.deleteById(id);
    }
}
