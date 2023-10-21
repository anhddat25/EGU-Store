package com.egustore.eshop.serviceimpl;


import com.egustore.eshop.dto.OrderDTO;
import com.egustore.eshop.mapper.OrderMapper;
import com.egustore.eshop.model.Order;
import com.egustore.eshop.repository.OrderRepository;
import com.egustore.eshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper)
    {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public Order createOrder(OrderDTO orderDTO) {
        Order order = OrderMapper.INSTANCE.mapToOrder(orderDTO);
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(int id){
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }


    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order updateOrder(int id,
                                   OrderDTO orderDTO) {
        Order existOrder = getOrderById(id);
        orderMapper.updateOrderFromDTO(orderDTO, existOrder);
        orderRepository.save(existOrder);
        return existOrder;
    }

    @Override
    public void deleteOrder(int id) {

        orderRepository.deleteById(id);
    }

}
