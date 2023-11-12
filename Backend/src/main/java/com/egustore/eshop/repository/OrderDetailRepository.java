package com.egustore.eshop.repository;

import com.egustore.eshop.dto.OrderDTO;
import com.egustore.eshop.dto.OrderDetailDTO;
import com.egustore.eshop.model.Order;
import com.egustore.eshop.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer> {
//    @Modifying
//    @Transactional
    @Query (value = "Select od.* from order_details od join orders o on od.order_id = o.Id where o.Id = :id", nativeQuery = true)
    List <OrderDetail>getOrderDetailByOrderID(@Param("id") Integer id);
}
