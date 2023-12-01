package com.egustore.eshop.repository;

import com.egustore.eshop.model.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HomeRepository extends JpaRepository<Home,Integer> {

    @Query(value ="SELECT p.id as id," +
            "p.model as Model, " +
            "p.thumbnail as thumbnail," +
            "p.price as Price," +
            "p.discount_price as Discount, " +
            "sum(r.Rating) as rate, " +
            "count(r.Rating) as count from egu_store.products p join egu_store.rating_products r " +
            "on r.product_id = p.id " +
            "group by r.product_id " +
            "UNION ALL " +
            "SELECT p.id as id, " +
            "p.model as Model, " +
            "p.thumbnail, " +
            "p.price as Price , " +
            "p.discount_price as Discount , " +
            "0 as rate, " +
            "0 as count from egu_store.products p Where p.id " +
            "not in (SELECT product_id FROM egu_store.rating_products)", nativeQuery = true)
    List<Home> getAllListWithRating();

}
