package com.egustore.eshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.lang.reflect.Type;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="Customer")
public class Customer {
    @Id
    private int id;
}
