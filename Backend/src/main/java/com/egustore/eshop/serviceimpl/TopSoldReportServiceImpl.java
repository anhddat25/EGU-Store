package com.egustore.eshop.serviceimpl;

import com.egustore.eshop.dto.TopSoldReportDTO;
import com.egustore.eshop.mapper.TopSoldReportMapper;
import com.egustore.eshop.repository.TopSoldReportRepository;
import com.egustore.eshop.service.TopSoldReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopSoldReportServiceImpl implements TopSoldReportService {
    private final TopSoldReportRepository topSoldReportRepository;

    private final TopSoldReportMapper topSoldReportMapper;
    @Autowired
    public TopSoldReportServiceImpl(TopSoldReportRepository topSoldReportRepository, TopSoldReportMapper topSoldReportMapper) {
        this.topSoldReportRepository = topSoldReportRepository;
        this.topSoldReportMapper = topSoldReportMapper;
    }
    

    @Override
    public List<TopSoldReportDTO> getTopSoldReport() {
        return topSoldReportMapper.toDTOList(topSoldReportRepository.getTopSold());
    }
}
