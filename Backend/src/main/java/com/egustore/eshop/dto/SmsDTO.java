package com.egustore.eshop.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SmsDTO {
    @NotBlank
    private final String phoneNumber="+84358677058";
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
