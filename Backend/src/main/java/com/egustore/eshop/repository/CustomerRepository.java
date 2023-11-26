package com.egustore.eshop.repository;

import com.egustore.eshop.dto.CustomerDTO;
import com.egustore.eshop.dto.OrderDTO;
import com.egustore.eshop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByEmail(String email);
    Optional<Customer> findByResetPasswordToken(String resetToken);
    @Modifying
    @Transactional
    @Query(value = "UPDATE customers " +
            "SET first_name = :firstName, " +
            "last_name = :lastName, " +
            "date_of_birth = :dateOfBirth, " +
            "phone_number = :phoneNumber " +
            "WHERE id = :id", nativeQuery = true)
    void updateProfileNative(int id, String firstName, String lastName, Date dateOfBirth, String phoneNumber);
    @Modifying
    @Transactional
    @Query(value = "UPDATE Customer c SET " +
            "c.status = :#{#customerDTO.status}, " +
            "c.roleId = :#{#customerDTO.roleId} " +
            "WHERE c.Id = :id")
    Integer updateStatusCustomer(@Param("customerDTO") CustomerDTO customerDTO, @Param("id") int id);
}
