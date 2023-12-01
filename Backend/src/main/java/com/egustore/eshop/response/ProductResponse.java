package com.egustore.eshop.response;

import com.egustore.eshop.model.Product;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class ProductResponse extends BaseResponse{
    private String name;
    private Double price;
    private String thumbImage;
    private String description;

    @JsonProperty("category_id")
    private Integer categoryId;
    public static ProductResponse fromProduct(Product product) {
        ProductResponse productResponse = ProductResponse.builder()
                .name(product.getName())
                .price(product.getPrice())
                .thumbImage(product.getThumbnail())
                .description(product.getDescription())
                .categoryId(product.getCategory().getId())
                .build();
        productResponse.setCreateDate(product.getCreateDate());
        productResponse.setUpdateDate(product.getUpdateDate());
        return productResponse;
    }
}
