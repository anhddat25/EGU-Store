package com.egustore.eshop.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_date")
    private LocalDateTime createDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "update_date")
    private LocalDateTime updateDate;
    @PrePersist
    protected void onCreate(){
        LocalDateTime now = LocalDateTime.now();
        createDate = now;
        updateDate = now;
    }

    @PreUpdate
    protected void onUpdate(){
        updateDate = LocalDateTime.now();
    }

}
