package com.egustore.eshop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SmsRequest {
    @NotBlank
    private final String phoneNumber="+84568072469";
    @NotBlank
    private final String message = "Có 1 đơn hàng mới được đặt thành công tại https://cellphones.com.vn/";

//    public SmsRequest(@JsonProperty("phoneNumber") String phoneNumber,@JsonProperty("message") String message) {
//        this.phoneNumber = phoneNumber;
//        this.message = message;
//    }

    @Override
    public String toString() {
        return "SmsRequest{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
