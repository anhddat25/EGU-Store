package com.egustore.eshop.mapper;


import com.egustore.eshop.dto.CategoryReportDTO;
import com.egustore.eshop.model.CategoryReport;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface CategoryReportMapper {
    CategoryReportMapper INSTANCE = Mappers.getMapper(CategoryReportMapper.class);

    CategoryReportDTO toDTO(CategoryReport incomeReport);

    CategoryReport toEntity(CategoryReportDTO incomeReportDTO);

    List<CategoryReportDTO> toDTOList(List<CategoryReport> orderDetails);
}
