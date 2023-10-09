package com.egustore.eshop.repository;

import com.egustore.eshop.dto.OrderDTO;
import com.egustore.eshop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE Order o SET o.email = :#{#orderDTO.email}, " +
            "o.phone = :#{#orderDTO.phone}, " +
            "o.orderDate = :#{#orderDTO.orderDate}, " +
            "o.note = :#{#orderDTO.note}, " +
            "o.status = :#{#orderDTO.status}, " +
            "o.paymentMethod = :#{#orderDTO.paymentMethod}, " +
            "o.discountPrice = :#{#orderDTO.discountPrice}, " +
            "o.customerId = :#{#orderDTO.customerId} WHERE o.id = :orderId")
    int updateOrderById(@Param("orderDTO") OrderDTO orderDTO, @Param("orderId") int orderId);
}

