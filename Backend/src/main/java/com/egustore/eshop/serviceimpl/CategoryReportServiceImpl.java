package com.egustore.eshop.serviceimpl;

import com.egustore.eshop.dto.CategoryReportDTO;
import com.egustore.eshop.mapper.CategoryReportMapper;
import com.egustore.eshop.mapper.CategoryReportMapper;
import com.egustore.eshop.repository.CategoryReportRepository;
import com.egustore.eshop.service.CategoryReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryReportServiceImpl implements CategoryReportService {
    private final CategoryReportRepository categoryReportRepository;
    
    private final CategoryReportMapper categoryReportMapper;

    @Autowired
    public CategoryReportServiceImpl(CategoryReportRepository categoryReportRepository, CategoryReportMapper categoryReportMapper) {
        this.categoryReportRepository = categoryReportRepository;
        this.categoryReportMapper = categoryReportMapper;
    }

    

    @Override
    public List<CategoryReportDTO> getCategoryQuantityReport() {
        return categoryReportMapper.toDTOList(categoryReportRepository.getCategoryQuantity());
    }
}
