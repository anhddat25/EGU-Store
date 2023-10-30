package com.egustore.eshop.service;

import com.egustore.eshop.dto.IncomeReportDTO;
import com.egustore.eshop.model.IncomeReport;

import java.util.Date;
import java.util.List;

public interface IncomeReportService {
    List<IncomeReportDTO> getAllIncomeReportByTime(Date from, Date to);
    List<IncomeReportDTO> getDefaultIncomeReport();
}
