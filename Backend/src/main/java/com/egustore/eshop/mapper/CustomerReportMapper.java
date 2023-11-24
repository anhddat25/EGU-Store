package com.egustore.eshop.mapper;

import com.egustore.eshop.dto.CustomerReportDTO;
import com.egustore.eshop.enums.CustomerStatus;
import com.egustore.eshop.model.CustomerReport;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerReportMapper {
    CustomerReportMapper INSTANCE = Mappers.getMapper(CustomerReportMapper.class);

    CustomerReportDTO toDTO(CustomerReport customerReport);

    CustomerReport toEntity(CustomerReportDTO customerReportDTO);

    List<CustomerReportDTO> toDTOList(List<CustomerReport> customerReportList);

    @Named("mapCustomerStatusToString")
    default String mapCustomerStatusToString(CustomerStatus status) {
        return status.name(); // Lấy tên của enum và ánh xạ vào trường status của DTO
    }
}
