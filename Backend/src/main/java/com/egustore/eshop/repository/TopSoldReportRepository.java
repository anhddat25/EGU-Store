package com.egustore.eshop.repository;




import com.egustore.eshop.model.TopSoldReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface TopSoldReportRepository extends JpaRepository<TopSoldReport, Integer> {

    @Query (value ="SELECT " +
            "p.id, " +
            "SUM(od.quantity) AS quantity, " +
            "SUM(od.quantity)*p.discount_price AS total_price, " +
            "c.name, " +
            "p.model, " +
            "p.thumbnail " +
            "FROM Products p " +
            "JOIN Categories c ON c.id = p.category_id " +
            "JOIN Order_Details od ON p.id = od.product_id " +
            "JOIN  Orders o ON od.order_id = o.id  WHERE o.status = 'DELIVERED' " +
            "GROUP BY p.id, c.name " +
            "ORDER BY total_price DESC; ", nativeQuery = true)
    List<TopSoldReport> getTopSold();

}
