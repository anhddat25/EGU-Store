package com.egustore.eshop.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.time.LocalDateTime;

@Data//toString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseResponse {
    @JsonProperty("create_date")
    private LocalDateTime createDate;

    @JsonProperty("update_date")
    private LocalDateTime updateDate;
}
