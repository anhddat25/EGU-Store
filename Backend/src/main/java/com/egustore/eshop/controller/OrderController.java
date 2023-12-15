package com.egustore.eshop.controller;

import com.egustore.eshop.dto.OrderDTO;
import com.egustore.eshop.model.Order;
import com.egustore.eshop.response.*;
import com.egustore.eshop.service.OrderService;
import com.egustore.eshop.utils.LocalizationUtils;
import com.egustore.eshop.utils.MessageKeys;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/orders")
@Validated
@CrossOrigin("*")
public class OrderController {
    private final OrderService orderService;

    private final LocalizationUtils localizationUtils;

    public OrderController(OrderService orderService, LocalizationUtils localizationUtils) {
        this.orderService = orderService;
        this.localizationUtils = localizationUtils;
    }


    //Create Order
    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody @Valid OrderDTO orderDTO, BindingResult result) {
        try {
            if(result.hasErrors())
            {
                List<String> errMessage = result.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errMessage);
            }
            orderService.saveOrder(orderDTO);
            return ResponseEntity.ok(CreateOrderResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.ORDER_SUCCESSFULLY)).build());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(CreateOrderResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.ORDER_FAILED,e.getMessage())).build());
        }

    }


    @GetMapping("")
    public ResponseEntity<List<Order>> getAllCategories() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @PutMapping("/get-item/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable int id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateOrderResponse> updateOrderById(@PathVariable int id,@RequestBody OrderDTO orderDTO) {
        try{
        orderService.updateOrderById(orderDTO, id);
        return ResponseEntity.ok(UpdateOrderResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.UPDATEORDER_SUCCESSFULLY)).build());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(UpdateOrderResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.UPDATEORDER_FAILED,e.getMessage())).build());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteOrderResponse> deleteOrder(@PathVariable int id) {
        try{
        orderService.deleteOrder(id);
        return ResponseEntity.ok(DeleteOrderResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.DELETEORDER_SUCCESSFULLY)).build());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(DeleteOrderResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.DELETEORDER_FAILED,e.getMessage())).build());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable int id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }
    @PutMapping("/status/{id}")
    public ResponseEntity<UpdateOrderStatusResponse> updateOrderStatus(@PathVariable int id, @RequestBody OrderDTO orderDTO) {
        try{
        orderService.updateOrderStatus(orderDTO, id);
        return ResponseEntity.ok(UpdateOrderStatusResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.ORDERSTATUS_SUCCESSFULLY)).build());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(UpdateOrderStatusResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.ORDERSTATUS_FAILED,e.getMessage())).build());
        }
    }


    @GetMapping("/list/{customerId}")
    public ResponseEntity<List<Order>> getOrderByCustomerId(@PathVariable int customerId){
        List<Order> orders = orderService.getOrderByCustomerId(customerId);
        return ResponseEntity.ok(orders);
    }
}