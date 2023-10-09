package com.egustore.eshop.controller;

import com.egustore.eshop.dto.OrderDTO;
import com.egustore.eshop.model.Order;
import com.egustore.eshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/orders")
public class OrderController {
    @Autowired
    OrderService orderService;


    //Create Order
    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(orderService.saveOrder(orderDTO));
    }

    @GetMapping("/list")
    public ResponseEntity<List<OrderDTO>> getAllCategories() {
        return ResponseEntity.ok(orderService.getOrderList());
    }

    @PutMapping("/get-item/{id}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable int id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable int id,@RequestBody OrderDTO orderDTO) {
        orderService.updateOrder(id,orderDTO);
        return ResponseEntity.ok("update Order " + id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok("delete Order " + id);
    }
}
