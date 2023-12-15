package com.egustore.eshop.model;

import com.egustore.eshop.enums.CategoryStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "categories")
public class Category  extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "{LOGIN_SUCCESSFULLY}")
    @Column(name = "name")
    private String name;
    @Column(name = "thumbnail")
    private String thumbnail;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CategoryStatus status;

}

