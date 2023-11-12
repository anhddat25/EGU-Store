package com.egustore.eshop.repository;

import com.egustore.eshop.dto.CustomerReportDTO;
import com.egustore.eshop.model.CustomerReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerReportRepository extends JpaRepository<CustomerReport,String> {
    @Query(value = "CALL spAllListOfCustomers()", nativeQuery = true)
    List<CustomerReport> getAllCustomerReport();
    @Query(value = "CALL spListBuyingCustomer()", nativeQuery = true)
    List<CustomerReport> getBuyingCustomerReport();
    @Query(value = "CALL spListNoneBuyingCustomer()", nativeQuery = true)
    List<CustomerReport> getNoneBuyingCustomerReport();
}
