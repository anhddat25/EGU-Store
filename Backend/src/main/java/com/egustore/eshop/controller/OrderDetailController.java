package com.egustore.eshop.controller;

import com.egustore.eshop.dto.OrderDTO;
import com.egustore.eshop.dto.OrderDetailDTO;
import com.egustore.eshop.model.Order;
import com.egustore.eshop.model.OrderDetail;
import com.egustore.eshop.service.OrderDetailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v0/order-details")
@Validated
@CrossOrigin("*")
public class OrderDetailController {
    private final OrderDetailService orderDetailService;

    @Autowired
    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    //Create Order
    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody @Valid OrderDetailDTO orderDetailDTO, BindingResult result) {
        if(result.hasErrors())
        {
            List<String> errMessage = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errMessage);
        }
        return ResponseEntity.ok(orderDetailService.createOrderDetail(orderDetailDTO));
    }

    @GetMapping("")
    public ResponseEntity<List<OrderDetail>> getAllOrderDetails() {
        return ResponseEntity.ok(orderDetailService.getAllOrderDetails());
    }

    @PutMapping("/get-item/{id}")
    public ResponseEntity<OrderDetail> updateOrder(@PathVariable int id) {
        return ResponseEntity.ok(orderDetailService.getOrderDetailById(id));
    }


//    @PutMapping("/update/{id}")
//    public ResponseEntity<String> updateCategory(@PathVariable int id,@RequestBody OrderDetailDTO orderDetailDTO) {
//        orderDetailService.updateOrderDetail(id,orderDetailDTO);
//        return ResponseEntity.ok("update OrderDetail " + id);
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable int id) {
        orderDetailService.deleteOrderDetail(id);
        return ResponseEntity.ok("delete OrderDetail " + id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderDetail> getOrderDetailById(@PathVariable int id) {
        return ResponseEntity.ok(orderDetailService.getOrderDetailById(id));
    }
    @GetMapping("/getByOrder/{id}")
    public ResponseEntity<List<OrderDetailDTO>>getOrderDetailByOrderID(@PathVariable Integer id) {
        return ResponseEntity.ok(orderDetailService.getOrderDetailByOrderID(id));
    }
    @PutMapping("/quantity/{id}")
    public ResponseEntity<String> updateQuantityDetail(@PathVariable int id,@RequestBody OrderDetailDTO orderDetailDTO) {
        orderDetailService.updateQuantityDetail(orderDetailDTO, id);
        return ResponseEntity.ok("update Quantity Order Detail " + id);
    }
}
