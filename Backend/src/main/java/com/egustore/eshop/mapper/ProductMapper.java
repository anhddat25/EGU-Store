package com.egustore.eshop.mapper;


import com.egustore.eshop.dto.OriginDTO;
import com.egustore.eshop.dto.ProductDTO;
import com.egustore.eshop.model.Origins;
import com.egustore.eshop.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    Product mapToProduct(ProductDTO productDTO);
    ProductDTO mapToProductDto(Product product );
    @Mapping(target = "id", ignore = true)
    void updateProductFromDTO(ProductDTO productDTO, @MappingTarget Product product);
}
