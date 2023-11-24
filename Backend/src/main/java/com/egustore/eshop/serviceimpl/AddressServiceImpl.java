package com.egustore.eshop.serviceimpl;

import com.egustore.eshop.dto.AddressDTO;
import com.egustore.eshop.mapper.AddressMapper;
import com.egustore.eshop.model.Address;
import com.egustore.eshop.repository.AddressRepository;
import com.egustore.eshop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, AddressMapper addressMapper)
    {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    public Address createAddress(AddressDTO AddressDTO) {
        Address Address = addressMapper.mapToAddress(AddressDTO);
        return addressRepository.save(Address);
    }

    @Override
    public Address getAddressById(int id){
        return addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found"));
    }



    @Override
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public Address updateAddress(int id, AddressDTO AddressDTO) {
        Address existAddress = getAddressById(id);
        addressMapper.updateAddressFromDTO(AddressDTO, existAddress);
        addressRepository.save(existAddress);
        return existAddress;
    }

    @Override
    public void deleteAddress(int id) {

        addressRepository.deleteById(id);
    }

}

