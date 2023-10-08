package com.egustore.eshop.controller;

import com.egustore.eshop.dto.CategoryDTO;
import com.egustore.eshop.dto.OrderDTO;
import com.egustore.eshop.model.Order;
import com.egustore.eshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

//    //Create Order
//    @PostMapping("/order")
//    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO orderDTO) {
//        return ResponseEntity.ok(orderService.saveOrder(orderDTO));
//    }
//
//    @GetMapping("/orders")
//    public ResponseEntity<List<OrderDTO>> getAllCategories() {
//        return ResponseEntity.ok(orderService.getOrderList());
//    }
//
//    @PutMapping("/order/{id}")
//    public ResponseEntity<OrderDTO> updateOrder(@PathVariable int id) {
//        return ResponseEntity.ok(orderService.getOrderById(id));
//    }

    //Create Order
    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(orderService.saveOrder(orderDTO));
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderDTO>> getAllCategories() {
        return ResponseEntity.ok(orderService.getOrderList());
    }

    @PutMapping("/get-item/{id}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable int id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Integer> updateCategory(@PathVariable int id,@RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(orderService.updateOrder(id,orderDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok("delete Order " + id);
    }
}
