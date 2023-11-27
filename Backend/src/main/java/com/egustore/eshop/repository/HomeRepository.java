package com.egustore.eshop.repository;

import com.egustore.eshop.model.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HomeRepository extends JpaRepository<Home,Integer> {

    @Query(value = "    SELECT p.id as 'id',\n" +
            "    p.model as \"Name\",\n" +
            "    p.thumbnail as \"thumbnail\",\n" +
            "    p.price as 'Price',\n" +
            "    p.discount_price as 'Discount',\n" +
            "    sum(r.Rating) as 'rate',\n" +
            "    count(r.Rating) as 'count' from egu_store.products p\n" +
            "    join egu_store.rating_products r\n" +
            "    on r.product_id = p.id group by r.product_id\n" +
            "    UNION ALL\n" +
            "    SELECT p.id as 'id',\n" +
            "    p.model as \"Name\",\n" +
            "    p.thumbnail,\n" +
            "    p.price as 'Price',\n" +
            "    p.discount_price as 'Discount',\n" +
            "            0 as 'rate',\n" +
            "            0 as 'count' from egu_store.products p\n" +
            "    Where p.id not in (SELECT product_id FROM egu_store.rating_products)", nativeQuery = true)
    List<Home> getAllListWithRating();

}
