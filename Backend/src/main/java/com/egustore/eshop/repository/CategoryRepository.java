package com.egustore.eshop.repository;

import com.egustore.eshop.enums.CategoryStatus;
import com.egustore.eshop.model.Category;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("SELECT c FROM Category c WHERE c.status = 'ACTIVE'")
    List<Category> getActiveCategories();
}
