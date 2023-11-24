package com.egustore.eshop.repository;

import com.egustore.eshop.model.Address;
import com.egustore.eshop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {

//    @Query(value = "SELECT a.* FROM address a  WHERE a.order_id = ?", nativeQuery = true)
//    List<Address> findBy(int productId);
}
