package com.egustore.eshop.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCountryResponse {
    @JsonProperty("message")
    private String message;
}
