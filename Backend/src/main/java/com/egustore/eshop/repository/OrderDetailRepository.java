package com.egustore.eshop.repository;

import com.egustore.eshop.dto.OrderDetailDTO;
import com.egustore.eshop.model.OrderDetail;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE OrderDetail o SET o.quantity = :#{#orderDetailDTO.quantity}, " +
            "o.totalPrice = :#{#orderDetailDTO.totalPrice}, " +
            "o.orderId = :#{#orderDetailDTO.orderId}, " +
            "o.productId = :#{#orderDetailDTO.productId} " +
            "WHERE o.Id = :id")
    Integer updateOrderDetailById(@Param("orderDetailDTO") OrderDetailDTO orderDetailDTO, @Param("id") int id);
}
