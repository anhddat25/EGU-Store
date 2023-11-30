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
    @Query(value = "select \n" +
            "\tdate(o.order_date) as 'Date',\n" +
            "\tcount(o.Id) as 'Orders', \n" +
            "\tsum(od.Quantity*od.total_price) 'Revenue' from egu_store.orders o \n" +
            "\tjoin egu_store.order_details od on  o.Id = od.order_id\n" +
            "     WHERE DATE(o.order_date) BETWEEN :startDate AND :endDate AND o.status = 'DELIVERED'\n" +
            "\tgroup by date(o.order_date)", nativeQuery = true)
    List<IncomeReport> spSelectedByYear(
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate
    );

    @Query(value = "\tselect \n" +
            "    date(o.order_date)as 'Date',\n" +
            "\tcount(o.Id) as 'Orders', \n" +
            "\tsum(od.Quantity*od.total_price) \"Revenue\" \n" +
            "    from egu_store.orders o \n" +
            "\tjoin egu_store.order_details od on  o.Id = od.order_id where o.status = 'DELIVERED'\n" +
            "\tgroup by date(o.order_date)", nativeQuery = true)
    List<IncomeReport> spSelectedDefaultByTime();
}
