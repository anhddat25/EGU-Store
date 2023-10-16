package com.egustore.eshop.serviceimpl;


import com.egustore.eshop.component.JwtTokenUtil;
import com.egustore.eshop.dto.CustomerDTO;
import com.egustore.eshop.mapper.CustomerMapper;
import com.egustore.eshop.model.Customer;
import com.egustore.eshop.repository.CustomerRepository;
import com.egustore.eshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private  final PasswordEncoder passwordEncoder;
    private  final JwtTokenUtil jwtTokenUtil;
    private  final AuthenticationManager authenticationManager;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper, PasswordEncoder passwordEncoder, JwtTokenUtil jwtTokenUtil, AuthenticationManager authenticationManager)
    {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenUtil = jwtTokenUtil;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Customer createCustomer(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.INSTANCE.mapToCustomer(customerDTO);
//        if (customer.getFacebookId() == null && customer.getGoogleId() == null) {
            String password = customer.getPassword();
            String encodePassword = passwordEncoder.encode(password);
            customer.setPassword(encodePassword);

//        }

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

    @Override
    public String login(String email, String password) throws Exception{
        Optional<Customer> optionalCustomer = customerRepository.findByEmail(email);
        if (optionalCustomer.isEmpty()){
            throw  new Exception("Invalid");
        }
        //return optionalCustomer.get();
        Customer customer = optionalCustomer.get();
        if (!passwordEncoder.matches(password, customer.getPassword()))
        {
            throw  new BadCredentialsException("Wrong email or password");
        }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email,password);
        authenticationManager.authenticate(authenticationToken);
        return jwtTokenUtil.generateToken(customer);
    }

}
