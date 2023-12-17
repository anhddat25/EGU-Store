package com.egustore.eshop.response;

import com.egustore.eshop.enums.OrderStatus;
import com.egustore.eshop.model.Order;
import com.egustore.eshop.model.OrderDetail;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {
    private Integer id;

    @JsonProperty("customer_id")
    private Integer customerId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("email")
    private String email;

    @JsonProperty("address")
    private String address;

    @JsonProperty( "district")
    private String district;

    @JsonProperty( "city")
    private String city;

    @JsonProperty( "country")
    private String country;

    @JsonProperty("note")
    private String note;

    @JsonProperty("order_date")
    private LocalDateTime orderDate;

    @JsonProperty("status")
    private OrderStatus status;

    @JsonProperty("total_price")
    private double totalMoney;

    @JsonProperty("payment_method")
    private String paymentMethod;

    @JsonProperty("order_details")
    private List<OrderDetail> orderDetails;

    public static OrderResponse fromOrder(Order order) {
        OrderResponse orderResponse =  OrderResponse
                .builder()
                .id(order.getId())
                .customerId(order.getCustomer().getId())
                .name(order.getName())
                .phone(order.getPhone())
                .email(order.getEmail())
                .address(order.getAddress())
                .note(order.getNote())
                .orderDate(order.getOrderDate())
                .status(order.getStatus())
                .totalMoney(order.getTotalPrice())
                .paymentMethod(order.getPaymentMethod())
//                .orderDetails(order.getOrderDetails())
                .build();
        return orderResponse;
    }
}
