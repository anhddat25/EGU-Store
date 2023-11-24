package com.egustore.eshop.serviceimpl;

import com.egustore.eshop.dto.OrderDTO;
import com.egustore.eshop.dto.OrderDetailDTO;
import com.egustore.eshop.model.Order;
import com.egustore.eshop.model.OrderDetail;
import com.egustore.eshop.mapper.OrderDetailMapper;
import com.egustore.eshop.repository.OrderDetailRepository;
import com.egustore.eshop.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderDetailServiceImp implements OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;
    private final OrderDetailMapper orderDetailMapper;

    @Autowired
    public OrderDetailServiceImp(OrderDetailRepository orderDetailRepository, OrderDetailMapper orderDetailMapper) {
        this.orderDetailRepository = orderDetailRepository;
        this.orderDetailMapper = orderDetailMapper;
    }

    @Override
    public OrderDetail createOrderDetail(OrderDetailDTO orderDetailDTO) {
        OrderDetail orderDetail = OrderDetailMapper.INSTANCE.toEntity(orderDetailDTO);
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public OrderDetail getOrderDetailById(int id) {
        return orderDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderDetail not found"));

    }

    @Override
    public List<OrderDetailDTO> getOrderDetailByOrderID(Integer id) {
        return orderDetailMapper.toDTOList(orderDetailRepository.getOrderDetailByOrderID(id));
    }

    @Override
    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailRepository.findAll();
    }

//    @Override
//    public Integer updateOrderDetail(int id, OrderDetailDTO orderDetailDTO) {
//        r
//    }

    @Override
    public void deleteOrderDetail(int id) {
        orderDetailRepository.deleteById(id);
    }
    public Integer updateQuantityDetail(OrderDetailDTO orderDetailDTO, int id) {

        return orderDetailRepository.updateQuantityDetail(orderDetailDTO, id);
    }
}
