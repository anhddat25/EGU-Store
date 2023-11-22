package com.egustore.eshop.repository;

import com.egustore.eshop.dto.OrderDTO;
import com.egustore.eshop.dto.OrderDetailDTO;
import com.egustore.eshop.model.Order;
import com.egustore.eshop.model.OrderDetail;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer> {
    //    @Modifying
//    @Transactional
    @Query (value = "Select od.* from orderDetails od join orders o on od.order_id = o.Id where o.Id = :id", nativeQuery = true)
    List <OrderDetail>getOrderDetailByOrderID(@Param("id") Integer id);

    @Modifying
    @Transactional
        @Query(value = "UPDATE OrderDetail o SET " +
                "o.quantity = :#{#orderDetailDTO.quantity} " +
                "WHERE o.id = :id")
        Integer updateQuantityDetail(@Param("orderDetailDTO") OrderDetailDTO orderDetailDTO, @Param("id") int id);
}
