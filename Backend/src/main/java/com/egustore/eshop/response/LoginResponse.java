package com.egustore.eshop.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {
    @JsonProperty("message")
    private String message;

    @JsonProperty("token")
    private String token;
}
