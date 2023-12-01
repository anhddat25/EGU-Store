package com.egustore.eshop.repository;

import com.egustore.eshop.dto.CustomerDTO;
import com.egustore.eshop.dto.OrderDTO;
import com.egustore.eshop.model.Customer;
//import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByEmail(String email);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Customer c SET " +
            "c.status = :#{#customerDTO.status}, " +
            "c.roleId = :#{#customerDTO.roleId} " +
            "WHERE c.Id = :id")
    Integer updateStatusCustomer(@Param("customerDTO") CustomerDTO customerDTO, @Param("id") int id);
}
