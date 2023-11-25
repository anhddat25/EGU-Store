package com.egustore.eshop.dto;

import com.egustore.eshop.model.City;
import com.egustore.eshop.model.Customer;
import com.egustore.eshop.model.Order;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class AddressDTO {
    private Integer id;

    private String streetNumber;

    private String street;

    private String district;

    @JsonProperty("city_id")
    private Integer cityId;

    private CityDTO city;


    @JsonProperty("customer_id")
    private Integer customerId;

    private CustomerDTO customer;

    @JsonProperty("order_id")
    private Integer orderId;

    private OrderDTO order;

}