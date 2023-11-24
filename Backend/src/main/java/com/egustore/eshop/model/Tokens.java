package com.egustore.eshop.model;

import com.egustore.eshop.enums.ImageStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "tokens")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tokens {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "token")
    private String title;

    @Column(name = "image_url")
    private String imageUrl;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "exp_date")
    private LocalDateTime expDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerId;
}
