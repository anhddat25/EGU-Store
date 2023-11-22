package com.egustore.eshop.dto;

import com.egustore.eshop.model.Country;
import jakarta.persistence.*;
import lombok.Data;


@Data
public class CityDTO {

    private Integer id;

    private String city;

    private Country countryId;
}
