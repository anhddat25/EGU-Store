package com.egustore.eshop.repository;

import com.egustore.eshop.model.Specifications;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SpecificationsRepository extends JpaRepository <Specifications, Integer>  {
//    @Modifying
//    @Transactional
//    @Query(value = "UPDATE Specifications s SET s.processor = :#{#specificaitonsDTO.processor}, " +
//            "s.graphicsCard = :#{#specificaitonsDTO.graphicsCard}, " +
//            "s.ram = :#{#specificaitonsDTO.ram}, " +
//            "s.storage = :#{#specificaitonsDTO.storage}, " +
//            "s.display = :#{#specificaitonsDTO.display}," +
//            "s.operatingSystem = :#{#specificaitonsDTO.operatingSystem}, " +
//            "s.camera = :#{#specificaitonsDTO.camera}, " +
//            "s.productId = :#{#specificaitonsDTO.productId} " +
//            "WHERE s.Id = :id")
//    Integer updateSpecById(@Param("specificaitonsDTO") SpecificationsDTO specificationsDTO, @Param("id") int id);


    Specifications findByProductId(int products);
}
