package com.egustore.eshop.serviceimpl;

import com.egustore.eshop.dto.CustomerReportDTO;
import com.egustore.eshop.mapper.CustomerReportMapper;
import com.egustore.eshop.repository.CustomerReportRepository;
import com.egustore.eshop.service.CustomerReportService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerReportServiceImpl implements CustomerReportService {
    private final CustomerReportRepository customerReportRepository;

    private final CustomerReportMapper customerReportMapper;

    public CustomerReportServiceImpl(CustomerReportRepository customerReportRepository, CustomerReportMapper customerReportMapper) {
        this.customerReportRepository = customerReportRepository;
        this.customerReportMapper = customerReportMapper;
    }


    @Override
    public List<CustomerReportDTO> getAllCustomerReport() {
        return customerReportMapper.toDTOList(customerReportRepository.getAllCustomerReport());
    }

    @Override
    public List<CustomerReportDTO> getBuyingCustomerReport() {
        return customerReportMapper.toDTOList(customerReportRepository.getBuyingCustomerReport());
    }

    @Override
    public List<CustomerReportDTO> getNoneBuyingCustomerReport() {
        return customerReportMapper.toDTOList(customerReportRepository.getNoneBuyingCustomerReport());
    }
}
