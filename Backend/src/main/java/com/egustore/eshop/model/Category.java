package com.egustore.eshop.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

//    @Column(name = "description")
//    private String description;

//    @Column(name = "status")
//    private String status;

//    @Column(name = "title")
//    private String title;
}

