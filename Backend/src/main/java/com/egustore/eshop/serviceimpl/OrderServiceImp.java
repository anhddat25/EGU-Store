package com.egustore.eshop.serviceimpl;

import com.egustore.eshop.dto.OrderDTO;
import com.egustore.eshop.model.Order;
import com.egustore.eshop.mapper.OrderMapper;
import com.egustore.eshop.repository.OrderRepository;
import com.egustore.eshop.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImp implements OrderService {

   private final OrderRepository orderRepository;

   private final OrderMapper orderMapper;

    public OrderServiceImp(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public Order saveOrder(OrderDTO orderDTO) {
        return orderRepository.save(orderMapper.toEntity(orderDTO));
    }

    @Override
    public Order getOrderById(int id) {
        return orderRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("order not found"));
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

//    @Override
//    public Integer updateOrder(int id, OrderDTO orderDTO) {
//        return orderRepository.updateOrderById(orderDTO, id);
//    }

    @Override
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }
}
