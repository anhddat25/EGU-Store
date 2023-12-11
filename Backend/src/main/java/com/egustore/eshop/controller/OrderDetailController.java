package com.egustore.eshop.controller;

import com.egustore.eshop.dto.OrderDetailDTO;
import com.egustore.eshop.model.OrderDetail;
import com.egustore.eshop.response.CreateOrderDetailResponse;
import com.egustore.eshop.response.DeleteOrderDetailResponse;
import com.egustore.eshop.response.DeleteOrderResponse;
import com.egustore.eshop.response.OrderDetailQuantityResponse;
import com.egustore.eshop.service.OrderDetailService;
import com.egustore.eshop.utils.LocalizationUtils;
import com.egustore.eshop.utils.MessageKeys;
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

    private final LocalizationUtils localizationUtils;

    @Autowired
    public OrderDetailController(OrderDetailService orderDetailService, LocalizationUtils localizationUtils) {
        this.orderDetailService = orderDetailService;
        this.localizationUtils = localizationUtils;
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
        orderDetailService.createOrderDetail(orderDetailDTO);
        return ResponseEntity.ok(CreateOrderDetailResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.ORDERDETAIL_SUCCESSFULLY)).build());
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
    public ResponseEntity<DeleteOrderDetailResponse> deleteOrder(@PathVariable int id) {
        orderDetailService.deleteOrderDetail(id);
        return ResponseEntity.ok(DeleteOrderDetailResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.DELETEORDERDETAIL_SUCCESSFULLY)).build());
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
    public ResponseEntity<OrderDetailQuantityResponse> updateQuantityDetail(@PathVariable int id,@RequestBody OrderDetailDTO orderDetailDTO) {
        orderDetailService.updateQuantityDetail(orderDetailDTO, id);
        return ResponseEntity.ok(OrderDetailQuantityResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.ORDERDETAILQUANTITY_SUCCESSFULLY)).build());
    }
}
