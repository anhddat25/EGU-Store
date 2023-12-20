package com.egustore.eshop.repository;

import com.egustore.eshop.dto.OrderDTO;
import com.egustore.eshop.model.FeedbackProduct;
import com.egustore.eshop.model.Order;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE Order o SET " +
            "o.email = :#{#orderDTO.email}, " +
            "o.phone = :#{#orderDTO.phone}, " +
            "o.orderDate = :#{#orderDTO.orderDate}, " +
            "o.note = :#{#orderDTO.note}, " +
            "o.status = :#{#orderDTO.status}, " +
            "o.paymentMethod = :#{#orderDTO.paymentMethod}, " +
            "o.discountPrice = :#{#orderDTO.discountPrice}, " +
            "o.customerId = :#{#orderDTO.customerId} " +
            // Remove the extra comma
            "WHERE o.id = :id")
    Integer updateOrderById(@Param("orderDTO") OrderDTO orderDTO, @Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Order o SET " +
            "o.status = :#{#orderDTO.status} " +
            "WHERE o.id = :id")
    Integer updateOrderStatus(@Param("orderDTO") OrderDTO orderDTO, @Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Order o SET " +
            "o.statusPayment = 'Đã thanh toán' " +
            "WHERE o.id = :id")
    Integer updateOrderStatusPayment(@Param("id") int id);

    @Query(value = "SELECT o.* FROM orders o  WHERE o.customer_id = ?", nativeQuery = true)
    List<Order> findByCustomerId(int productId);
}