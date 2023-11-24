package com.egustore.eshop.repository;

import com.egustore.eshop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("SELECT c FROM Category c WHERE c.status = 'ACTIVE'")
    List<Category> getActiveCategories();

//    @Modifying
//    @Transactional
//    @Query("UPDATE Category c SET c.name = :name  " +
//            "c.status = :status" +
//            " WHERE c.id = :categoryId")
//    void updateCategory(@Param("categoryId") Integer categoryId, @Param("name") String name, @Param("status") CategoryStatus status);

}
