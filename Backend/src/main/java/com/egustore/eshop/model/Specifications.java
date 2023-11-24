package com.egustore.eshop.model;

import com.egustore.eshop.model.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "specifications")
public class Specifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "processor")
    private String processor;

    @Column(name = "graphics_card")
    private String graphicsCard;

    @Column(name = "ram")
    private String ram;

    @Column(name = "storage")
    private String storage;

    @Column(name = "display")
    private String display;

    @Column(name = "operating_system")
    private String operatingSystem;

    @Column(name = "camera")
    private String camera;




    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

//    @Column(name = "product_id", insertable=false, updatable=false)
//    private Integer productId;
}
