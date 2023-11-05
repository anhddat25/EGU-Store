package com.egustore.eshop.repository;

import com.egustore.eshop.dto.IncomeReportDTO;
import com.egustore.eshop.model.IncomeReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface IncomeReportRepository extends JpaRepository<IncomeReport, Date> {
    @Query(value = "CALL spSelectedByYear(:startDate, :endDate)", nativeQuery = true)
    List<IncomeReport> spSelectedByYear(
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate
    );

    @Query(value = "CALL spSelectedDefaultByYear()", nativeQuery = true)
    List<IncomeReport> spSelectedDefaultByTime();
}
