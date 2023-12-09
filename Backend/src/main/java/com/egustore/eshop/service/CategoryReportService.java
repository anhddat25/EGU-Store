package com.egustore.eshop.service;

import com.egustore.eshop.dto.CategoryReportDTO;
import com.egustore.eshop.dto.TopSoldReportDTO;

import java.util.List;

public interface CategoryReportService {

    List<CategoryReportDTO> getCategoryQuantityReport();
}
