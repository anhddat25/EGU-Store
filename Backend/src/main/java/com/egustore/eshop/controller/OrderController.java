package com.egustore.eshop.controller;

import com.egustore.eshop.dto.OrderDTO;
import com.egustore.eshop.model.Order;
import com.egustore.eshop.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/orders")
@Validated
public class OrderController {
    @Autowired
    OrderService orderService;


    //Create Order
    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody @Valid OrderDTO orderDTO, BindingResult result) {
        if(result.hasErrors())
        {
            List<String> errMessage = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errMessage);
        }
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
