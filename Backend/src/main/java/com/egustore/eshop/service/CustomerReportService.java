package com.egustore.eshop.service;

import com.egustore.eshop.dto.CustomerReportDTO;

import java.util.List;

public interface CustomerReportService {
    List<CustomerReportDTO> getAllCustomerReport();
    List<CustomerReportDTO> getBuyingCustomerReport();
    List<CustomerReportDTO> getNoneBuyingCustomerReport();
}
