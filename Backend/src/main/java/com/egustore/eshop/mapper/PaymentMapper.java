package com.egustore.eshop.mapper;

import com.egustore.eshop.dto.CategoryDTO;
import com.egustore.eshop.dto.PaymentDTO;
import com.egustore.eshop.model.Category;
import com.egustore.eshop.model.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);
    Payment mapToPayment(PaymentDTO paymentDTO);
    PaymentDTO mapToPaymentDTO(Payment payment);
    @Mapping(target = "version", ignore = true)
    void updatePaymentFromDTO(PaymentDTO paymentDTO, @MappingTarget Payment payment);
}
