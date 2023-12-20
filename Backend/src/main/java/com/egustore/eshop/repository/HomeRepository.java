package com.egustore.eshop.repository;

import com.egustore.eshop.model.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HomeRepository extends JpaRepository<Home,Integer> {

    @Query(value ="SELECT\n" +
            "    p.id AS id,\n" +
            "    p.model AS Model,\n" +
            "    p.thumbnail AS thumbnail,\n" +
            "    p.price AS Price,\n" +
            "    p.discount_price AS Discount,\n" +
            "    COALESCE(SUM(r.Rating), 0) AS rate,\n" +
            "    COALESCE(COUNT(r.Rating), 0) AS count\n" +
            "FROM\n" +
            "    egu_store.products p\n" +
            "LEFT JOIN\n" +
            "    egu_store.rating_products r ON r.product_id = p.id\n" +
            "WHERE\n" +
            "    p.status = 'AVAILABLE'\n" +
            "GROUP BY\n" +
            "    p.id\n" +
            "\n" +
            "UNION ALL\n" +
            "\n" +
            "SELECT\n" +
            "    p.id AS id,\n" +
            "    p.model AS Model,\n" +
            "    p.thumbnail,\n" +
            "    p.price AS Price,\n" +
            "    p.discount_price AS Discount,\n" +
            "    0 AS rate,\n" +
            "    0 AS count\n" +
            "FROM\n" +
            "    egu_store.products p\n" +
            "WHERE\n" +
            "    p.id NOT IN (SELECT product_id FROM egu_store.rating_products)\n" +
            "    AND p.status = 'AVAILABLE'", nativeQuery = true)
    List<Home> getAllListWithRating();

}
