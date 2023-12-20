package com.egustore.eshop.mapper;


import com.egustore.eshop.dto.TopSoldReportDTO;
import com.egustore.eshop.model.TopSoldReport;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface TopSoldReportMapper {
    TopSoldReportMapper INSTANCE = Mappers.getMapper(TopSoldReportMapper.class);

    TopSoldReportDTO toDTO(TopSoldReport incomeReport);

    TopSoldReport toEntity(TopSoldReportDTO incomeReportDTO);

    List<TopSoldReportDTO> toDTOList(List<TopSoldReport> orderDetails);
}
