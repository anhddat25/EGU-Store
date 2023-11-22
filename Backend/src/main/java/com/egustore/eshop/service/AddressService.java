package com.egustore.eshop.service;

import com.egustore.eshop.dto.AddressDTO;
import com.egustore.eshop.model.Address;

import java.util.List;

public interface AddressService {

    Address createAddress(AddressDTO AddressDTO);

    Address getAddressById(int id);

    List<Address> getAllAddress();

    Address updateAddress(int id, AddressDTO AddressDTO);

    void deleteAddress(int id);
}

