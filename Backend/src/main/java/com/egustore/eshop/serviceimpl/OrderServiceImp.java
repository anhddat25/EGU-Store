package com.egustore.eshop.serviceimpl;

import com.egustore.eshop.dto.OrderDTO;
import com.egustore.eshop.model.Order;
import com.egustore.eshop.mapper.OrderMapper;
import com.egustore.eshop.repository.OrderRepository;
import com.egustore.eshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderMapper orderMapper;

    @Override
    public Order saveOrder(OrderDTO orderDTO) {
        return orderRepository.save(orderMapper.toEntity(orderDTO));
    }

    @Override
    public OrderDTO getOrderById(int id) {
        return orderRepository
                .findById(id)
                .map(orderMapper::toDTO)
                .orElse(new OrderDTO());
    }

    @Override
    public List<OrderDTO> getOrderList() {
        return orderMapper.toDTOList(orderRepository.findAll());
    }

    @Override
    public Integer updateOrder(int id, OrderDTO orderDTO) {
        return orderRepository.updateOrderById(orderDTO, id);
    }

    @Override
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }
}
