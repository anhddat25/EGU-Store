package com.egustore.eshop.model;

import com.egustore.eshop.enums.ImageStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "images")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "image_url")
    private String image_url;

    @Temporal(TemporalType.DATE)
    @Column(name = "create_date")
    private Date create_date;

    @Temporal(TemporalType.DATE)
    @Column(name = "update_date")
    private Date update_date;

    @Column(name = "product_id")
    private Integer product_id;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ImageStatus imageStatus;
}
