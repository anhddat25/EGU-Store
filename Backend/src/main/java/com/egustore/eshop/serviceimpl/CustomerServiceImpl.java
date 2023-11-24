package com.egustore.eshop.serviceimpl;


import com.egustore.eshop.component.JwtTokenUtil;
import com.egustore.eshop.controller.ProductController;
import com.egustore.eshop.dto.CustomerDTO;
import com.egustore.eshop.dto.ChangePasswordDTO;
import com.egustore.eshop.dto.ForgotPasswordDTO;
import com.egustore.eshop.dto.ResetPasswordDTO;
import com.egustore.eshop.mapper.CustomerMapper;
import com.egustore.eshop.model.Customer;
import com.egustore.eshop.model.Role;
import com.egustore.eshop.repository.CustomerRepository;
import com.egustore.eshop.repository.RoleRepository;
import com.egustore.eshop.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    private final CustomerRepository customerRepository;
    private final RoleRepository roleRepository;
    private final CustomerMapper customerMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;
    private final JavaMailSender emailSender;
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, RoleRepository roleRepository, CustomerMapper customerMapper, PasswordEncoder passwordEncoder, JwtTokenUtil jwtTokenUtil, AuthenticationManager authenticationManager, JavaMailSender emailSender)
    {
        this.customerRepository = customerRepository;
        this.roleRepository = roleRepository;
        this.customerMapper = customerMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenUtil = jwtTokenUtil;
        this.authenticationManager = authenticationManager;
        this.emailSender = emailSender;
    }

    @Override
    public void updateProfile(int id, CustomerDTO customerDTO) {
        customerRepository.updateProfileNative(id, customerDTO.getFirstName(), customerDTO.getLastName(),customerDTO.getDateOfBirth(), customerDTO.getPhoneNumber());
    }
    @Override
    public void changePassword(int id, ChangePasswordDTO changePasswordDTO){
        Customer customerCP = getCustomerById(id);
        if (passwordEncoder.matches(changePasswordDTO.getOldPassword(), customerCP.getPassword())) {
            if (!changePasswordDTO.getNewPassword().equals(changePasswordDTO.getOldPassword())) {
                String encodedNewPassword = passwordEncoder.encode(changePasswordDTO.getNewPassword());
                customerCP.setPassword(encodedNewPassword);
                customerRepository.save(customerCP);
            } else {
                throw new IllegalArgumentException("Mật khẩu mới không được trùng mật khẩu cũ");
            }
        } else {
            throw new IllegalArgumentException("Mật khẩu cũ không đúng");
        }
    }
    @Override
    public void forgotPassword(ForgotPasswordDTO forgotPasswordDTO) {
        String email = forgotPasswordDTO.getEmail();
        Customer customer = customerRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Địa chỉ email không tồn tại"));
        String resetToken = generateResetToken();
        customer.setResetPasswordToken(resetToken);
        customerRepository.save(customer);
        sendResetTokenEmail(email, resetToken);
    }
    private String generateResetToken() {
        return UUID.randomUUID().toString();
    }
    private void sendResetTokenEmail(String email, String resetToken) {
        try {
            String htmlContent = "Mã khôi phục: "+resetToken;
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("Khôi phục mật khẩu");
            message.setText(htmlContent);
            message.setFrom("Admin");
            emailSender.send(message);
        } catch (Exception e) {
            System.err.println("Lỗi khi gửi email: " + e.getMessage());
            e.printStackTrace();
        }
    }
    @Override
    public void resetPassword(ResetPasswordDTO resetPasswordDTO) {
        String resetPasswordToken = resetPasswordDTO.getResetPasswordToken();
        String newPassword = resetPasswordDTO.getNewPassword();
        Customer customer = customerRepository.findByResetPasswordToken(resetPasswordToken)
                .orElseThrow(() -> new IllegalArgumentException("resetPasswordToken không họp lệ"));
        String encodedNewPassword = passwordEncoder.encode(newPassword);
        customer.setPassword(encodedNewPassword);
        customer.setResetPasswordToken(null);
        customerRepository.save(customer);
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
    public Integer updateStatusCustomer(CustomerDTO customerDTO, int id) {
        return customerRepository.updateStatusCustomer(customerDTO, id);
    }

    @Override
    public void deleteCustomer(int id) {

        customerRepository.deleteById(id);
    }

    @Override
    public String login(String email, String password) throws Exception{
        LOGGER.info(String.format("email = %s", email));
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

    @Override
    public Customer getCustomerDetails(String token) throws Exception {
        if (jwtTokenUtil.isTokenExpired(token)){
            throw new Exception("Token is expired");
        }
        String email = jwtTokenUtil.extraEmail(token);
        Optional<Customer> customer = customerRepository.findByEmail(email);
        if (customer.isPresent()){
            return customer.get();
        } else
        {
            throw  new Exception("Customer not found");
        }
    }
}
