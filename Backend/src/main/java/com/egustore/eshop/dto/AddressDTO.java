package com.egustore.eshop.dto;

import com.egustore.eshop.model.City;
import com.egustore.eshop.model.Customer;
import com.egustore.eshop.model.Order;
import lombok.Data;


@Data
public class AddressDTO {
    private Integer id;

    private String streetNumber;

    private String street;

    private City city;

    private Customer customerId;

    private Order orderId;

}
