package com.egustore.eshop.serviceimpl;

import com.egustore.eshop.dto.IncomeReportDTO;
import com.egustore.eshop.mapper.IncomeReportMapper;
import com.egustore.eshop.model.IncomeReport;
import com.egustore.eshop.repository.IncomeReportRepository;
import com.egustore.eshop.service.IncomeReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class IncomeReportServiceImpl implements IncomeReportService {
    private final IncomeReportRepository incomeReportRepository;

    private final IncomeReportMapper incomeReportMapper;
    @Autowired
    public IncomeReportServiceImpl(IncomeReportRepository incomeReportRepository, IncomeReportMapper incomeReportMapper) {
        this.incomeReportRepository = incomeReportRepository;
        this.incomeReportMapper = incomeReportMapper;
    }


    @Override
    public List<IncomeReportDTO> getAllIncomeReportByTime(Date from, Date to) {
        return incomeReportMapper.toDTOList(incomeReportRepository.spSelectedByYear(from,to));
    }

    @Override
    public List<IncomeReportDTO> getDefaultIncomeReport() {
        return incomeReportMapper.toDTOList(incomeReportRepository.spSelectedDefaultByTime());
    }
}
