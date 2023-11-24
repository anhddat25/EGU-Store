package com.egustore.eshop.mapper;

import com.egustore.eshop.dto.IncomeReportDTO;
import com.egustore.eshop.model.IncomeReport;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface IncomeReportMapper {
    IncomeReportMapper INSTANCE = Mappers.getMapper(IncomeReportMapper.class);

     IncomeReportDTO toDTO(IncomeReport incomeReport);

    IncomeReport toEntity(IncomeReportDTO incomeReportDTO);

    List<IncomeReportDTO> toDTOList(List<IncomeReport> orderDetails);
}
