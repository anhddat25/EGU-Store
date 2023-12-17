package com.egustore.eshop.serviceimpl;

import com.egustore.eshop.dto.CartItemDTO;
import com.egustore.eshop.dto.OrderDTO;
import com.egustore.eshop.enums.OrderStatus;
import com.egustore.eshop.model.Customer;
import com.egustore.eshop.model.Order;
import com.egustore.eshop.mapper.OrderMapper;
import com.egustore.eshop.model.OrderDetail;
import com.egustore.eshop.model.Product;
import com.egustore.eshop.repository.CustomerRepository;
import com.egustore.eshop.repository.OrderDetailRepository;
import com.egustore.eshop.repository.OrderRepository;
import com.egustore.eshop.repository.ProductRepository;
import com.egustore.eshop.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;

    private final CustomerRepository customerRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final ProductRepository productRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper, CustomerRepository customerRepository, OrderDetailRepository orderDetailRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.customerRepository = customerRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Order saveOrder(OrderDTO orderDTO) {
        Customer customer = customerRepository
                .findById(orderDTO.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Cannot find user with id: " + orderDTO.getCustomerId()));
        Order order = orderMapper.toEntity(orderDTO);
        order.setStatus(OrderStatus.PENDING);
        orderRepository.save(order);
        List<OrderDetail> orderDetails = new ArrayList<>();
        for (CartItemDTO cartItemDTO : orderDTO.getCartItems()) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(order);

            Integer productId = cartItemDTO.getProductId();
            int quantity = cartItemDTO.getQuantity();

            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

            orderDetail.setProduct(product);
            orderDetail.setQuantity(quantity);
            orderDetail.setPrice(product.getPrice());
            orderDetails.add(orderDetail);
        }

        orderDetailRepository.saveAll(orderDetails);
        return order;
    }

    @Override
    public Order getOrderById(int id) {
        return orderRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("order not found"));
    }



//    @Override
//    public Integer updateOrder(int id, OrderDTO orderDTO) {
//        return orderRepository.updateOrderById(orderDTO, id);
//    }

    @Override
    public Order updateOrder(int id, OrderDTO orderDTO) {
        Order existOrder = getOrderById(id);
        orderMapper.updateOrderFromDTO(orderDTO, existOrder);
        orderRepository.save(existOrder);
        return existOrder;
    }
    @Override
    @Transactional
    public void deleteOrder(int id) {
        Order order = orderRepository.findById(id).orElse(null);
        if(order != null) {
            order.setIsActive(false);
            orderRepository.save(order);
        }
    }

    @Override
    public Integer updateOrderById(OrderDTO orderDTO, int id) {
            return null;
//        return orderRepository.updateOrderById(orderDTO, id);
    }
    public Integer updateOrderStatus(OrderDTO orderDTO, int id) {

        return orderRepository.updateOrderStatus(orderDTO, id);
    }

    @Override
    public List<Order> getOrderByCustomerId(int customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

}