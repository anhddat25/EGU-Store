package com.egustore.eshop.repository;


import com.egustore.eshop.model.CategoryReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryReportRepository extends JpaRepository<CategoryReport, Integer> {



    @Query(value = "SELECT " +
            "c.id, " +
            "c.name, " +
            "SUM(od.quantity) AS quantity, " +
            "SUM(od.quantity * p.discount_price) AS total_price " +
            "FROM Products p " +
            "JOIN Categories c ON c.id = p.category_id " +
            "JOIN Order_Details od ON p.id = od.product_id " +
            "JOIN Orders o ON od.order_id = o.id WHERE o.status = 'DELIVERED' " +
            "GROUP BY c.name, c.id " +
            "ORDER BY quantity DESC;", nativeQuery = true)
    List<CategoryReport> getCategoryQuantity();

}
