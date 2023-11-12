package com.egustore.eshop.serviceimpl;


import com.egustore.eshop.component.JwtTokenUtil;
import com.egustore.eshop.dto.CustomerDTO;
import com.egustore.eshop.mapper.CustomerMapper;
import com.egustore.eshop.model.Customer;
import com.egustore.eshop.model.Role;
import com.egustore.eshop.repository.CustomerRepository;
import com.egustore.eshop.repository.RoleRepository;
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
    private final RoleRepository roleRepository;
    private final CustomerMapper customerMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, RoleRepository roleRepository, CustomerMapper customerMapper, PasswordEncoder passwordEncoder, JwtTokenUtil jwtTokenUtil, AuthenticationManager authenticationManager)
    {
        this.customerRepository = customerRepository;
        this.roleRepository = roleRepository;
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
    public Integer updateStatusCustomer(Integer id, CustomerDTO customerDTO) {
        return customerRepository.updateStatusCustomer(customerDTO, id);
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
        } Customer customer = optionalCustomer.get();
        Role role = roleRepository.findById(customer.getRole().getId())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        if (!passwordEncoder.matches(password, customer.getPassword()))
        {
            throw  new BadCredentialsException("Wrong email or password");
        }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email,password ,customer.getAuthorities());
        authenticationManager.authenticate(authenticationToken);
        return jwtTokenUtil.generateToken(customer);
    }

}
