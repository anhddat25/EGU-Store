package com.egustore.eshop.dto;

import lombok.Data;

@Data
public class ResetPasswordDTO {
    private String resetPasswordToken;
    private String newPassword;
}