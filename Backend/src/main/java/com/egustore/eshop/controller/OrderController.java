package com.egustore.eshop.controller;

import com.egustore.eshop.dto.OrderDTO;
import com.egustore.eshop.model.Order;
import com.egustore.eshop.model.Product;
import com.egustore.eshop.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v0/orders")
@Validated
@CrossOrigin("*")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    //Create Order
    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody @Valid List<OrderDTO> orderDTOList, BindingResult result) {
       try {
           if(result.hasErrors())
           {
               List<String> errMessage = result.getFieldErrors()
                       .stream()
                       .map(FieldError::getDefaultMessage)
                       .toList();
               return ResponseEntity.badRequest().body(errMessage);
           }
           orderService.saveOrders(orderDTOList);
           return ResponseEntity.ok("Succes!");

       }catch (Exception e){
           return ResponseEntity.badRequest().body(e.getMessage());
       }

    }

    @GetMapping(" ")
    public ResponseEntity<List<Order>> getAllCategories() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

//    @PutMapping("/get-item/{id}")
//    public ResponseEntity<Order> updateOrder(@PathVariable int id) {
//        return ResponseEntity.ok(orderService.getOrderById(id));
//    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateOrderById(@PathVariable int id,@RequestBody OrderDTO orderDTO) {
        orderService.updateOrderById(orderDTO, id);
        return ResponseEntity.ok("update Order " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok("delete order " + id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable int id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }
    @PutMapping("/status/{id}")
    public ResponseEntity<String> updateOrderStatus(@PathVariable int id,@RequestBody OrderDTO orderDTO) {
        orderService.updateOrderStatus(orderDTO, id);
        return ResponseEntity.ok("update Order " + id);
    }
}
