package com.egustore.eshop.dto;

import com.egustore.eshop.enums.CustomerStatus;
import com.egustore.eshop.model.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

@Data
public class CustomerDTO {

    private Integer id;

//    @NotBlank(message = "Không được để trống!")
    private String firstName;

//    @NotBlank(message = "Không được để trống!")
    private String lastName;

    private Date dateOfBirth;

//    @Email(message = "Email không hợp lệ!")
    private String email;

//    @Pattern(regexp = "^[0-9]+$", message = "Số điện thoại phải là số")
//    @Size(min=11, max=13, message = "Số điện thoại chưa đúng!")
    private String phoneNumber;

//    @NotBlank(message = "Mật khẩu không được để trống!")
//    @Min(value = 8, message = "Mật khẩu không được ít hơn 8 ký tự!")
//    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@_\\-()<>/])+$", message = "Mật khẩu chỉ bao gồm chũ in hoa, chữ thường, số và các kí tự {@_-()<>/}")
    private String password;

    private Date createDate;

    private String facebookId;

    private String googleId;

    private String resetPasswordToken;

    @JsonProperty("role_id")
    private Integer roleId;

    private RoleDTO role;

    @Enumerated(EnumType.STRING)
    private CustomerStatus status;
}
