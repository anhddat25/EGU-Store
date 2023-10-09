package com.egustore.eshop.controller;

import com.egustore.eshop.dto.OrderDetailDTO;
import com.egustore.eshop.model.OrderDetail;
import com.egustore.eshop.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v0/order-details")
public class OrderDetailController {
    @Autowired
    OrderDetailService orderDetailService;

    //Create Order
    @PostMapping("/create")
    public ResponseEntity<OrderDetail> createOrder(@RequestBody OrderDetailDTO orderDetailDTO) {
        return ResponseEntity.ok(orderDetailService.saveOrder(orderDetailDTO));
    }

    @GetMapping("/list")
    public ResponseEntity<List<OrderDetailDTO>> getAllOrderDetail() {
        return ResponseEntity.ok(orderDetailService.getOrderDetailList());
    }

    @PutMapping("/get-item/{id}")
    public ResponseEntity<OrderDetailDTO> updateOrder(@PathVariable int id) {
        return ResponseEntity.ok(orderDetailService.getOrderDetailById(id));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable int id,@RequestBody OrderDetailDTO orderDetailDTO) {
        orderDetailService.updateOrderDetail(id,orderDetailDTO);
        return ResponseEntity.ok("update OrderDetail " + id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable int id) {
        orderDetailService.deleteOrderDetail(id);
        return ResponseEntity.ok("delete OrderDetail " + id);
    }
}
