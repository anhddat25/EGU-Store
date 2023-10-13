package com.egustore.eshop.serviceimpl;


import com.egustore.eshop.dto.CustomerDTO;
import com.egustore.eshop.mapper.CustomerMapper;
import com.egustore.eshop.model.Customer;
import com.egustore.eshop.repository.CustomerRepository;
import com.egustore.eshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper)
    {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public Customer createCustomer(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.INSTANCE.mapToCustomer(customerDTO);
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(int id){
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }



    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(int id,
                                   CustomerDTO customerDTO) {
        Customer existCustomer = getCustomerById(id);
        customerMapper.updateCustomerFromDTO(customerDTO, existCustomer);
        customerRepository.save(existCustomer);
        return existCustomer;
    }

    @Override
    public void deleteCustomer(int id) {

        customerRepository.deleteById(id);
    }

}
