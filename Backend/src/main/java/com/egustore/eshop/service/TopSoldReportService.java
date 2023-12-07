package com.egustore.eshop.service;

import com.egustore.eshop.dto.CategoryReportDTO;
import com.egustore.eshop.dto.IncomeReportDTO;
import com.egustore.eshop.dto.TopSoldReportDTO;

import java.util.Date;
import java.util.List;

public interface TopSoldReportService {

    List<TopSoldReportDTO> getTopSoldReport();

}
