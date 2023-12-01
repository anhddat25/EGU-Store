package com.egustore.eshop.repository;

import com.egustore.eshop.dto.CustomerReportDTO;
import com.egustore.eshop.model.CustomerReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerReportRepository extends JpaRepository<CustomerReport,String> {
    @Query(value = "SELECT CONCAT(c.first_name, ' ', c.last_name) AS 'name',\n" +
            "\t\t   SUM(od.Quantity * od.total_price) AS 'revenue',\n" +
            "\t\t   c.date_of_birth as 'birth_date',\n" +
            "\t\t   c.Email as 'email',\n" +
            "\t\t   c.phone_number as 'phone',\n" +
            "\t\t   c.create_date as 'day_created',\n" +
            "\t\t   c.status as 'status'\n" +
            "\tFROM customers c\n" +
            "\tJOIN orders o ON c.Id = o.customer_id\n" +
            "\tJOIN order_details od ON o.Id = od.order_id where o.status = 'DELIVERED'\n" +
            "\tGROUP BY c.Id\n" +
            "\tUNION ALL\n" +
            "\tSELECT CONCAT(c.first_name, ' ', c.last_name) AS 'name',\n" +
            "\t\t   0 AS 'revenue',\n" +
            "\t\t   c.date_of_birth as 'birth',\n" +
            "\t\t   c.Email as 'email',\n" +
            "\t\t   c.phone_number as 'phone',\n" +
            "\t\t   c.create_date as 'day_created',\n" +
            "\t\t   c.status as 'status'\n" +
            "\tFROM customers c\n" +
            "\tWHERE c.Id NOT IN (SELECT customer_id FROM orders)\n" +
            "\tORDER BY revenue DESC", nativeQuery = true)
    List<CustomerReport> getAllCustomerReport();
    @Query(value = "SELECT CONCAT(c.first_name, ' ', c.last_name) AS 'name',\n" +
            "       SUM(od.Quantity * od.total_price) AS 'revenue',\n" +
            "       c.date_of_birth as 'birth_date',\n" +
            "       c.Email as 'email',\n" +
            "       c.phone_number as 'phone',\n" +
            "       c.create_date as 'day_created',\n" +
            "       c.status as 'status'\n" +
            "\t\tFROM customers c\n" +
            "\t\tJOIN orders o ON c.Id = o.customer_id \n" +
            "\t\tJOIN order_details od ON o.Id = od.order_id where o.status = 'DELIVERED'\n" +
            "\t\tGROUP BY c.Id ORDER BY revenue DESC", nativeQuery = true)
    List<CustomerReport> getBuyingCustomerReport();
    @Query(value = "SELECT CONCAT(c.first_name, ' ', c.last_name) AS 'name',\n" +
            "\t\t   0 AS 'revenue',\n" +
            "\t\t   c.date_of_birth as 'birth_date',\n" +
            "\t\t   c.Email as 'email',\n" +
            "\t\t   c.phone_number as 'phone',\n" +
            "\t\t   c.create_date as 'day_created',\n" +
            "\t\t   c.status as 'status'\n" +
            "\tFROM customers c\n" +
            "\tWHERE c.Id NOT IN (SELECT customer_id FROM orders)", nativeQuery = true)
    List<CustomerReport> getNoneBuyingCustomerReport();
}
