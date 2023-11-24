package com.egustore.eshop.repository;

import com.egustore.eshop.dto.ProductDTO;
import com.egustore.eshop.dto.SpecificationsDTO;
import com.egustore.eshop.model.Specifications;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SpecificationsRepository extends JpaRepository <Specifications, Integer>  {
    @Modifying
    @Transactional
    @Query(value = "UPDATE Specifications s SET s.processor = :#{#specificaitonsDTO.processor}, " +
            "s.graphicsCard = :#{#specificaitonsDTO.graphicsCard}, " +
            "s.ram = :#{#specificaitonsDTO.ram}, " +
            "s.storage = :#{#specificaitonsDTO.storage}, " +
            "s.display = :#{#specificaitonsDTO.display}," +
            "s.operatingSystem = :#{#specificaitonsDTO.operatingSystem}, " +
            "s.camera = :#{#specificaitonsDTO.camera}, " +
            "s.productId = :#{#specificaitonsDTO.productId} " +
            "WHERE s.Id = :id")
    Integer updateSpecById(@Param("specificaitonsDTO") SpecificationsDTO specificationsDTO, @Param("id") int id);
}
