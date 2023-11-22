package com.egustore.eshop.service;

import com.egustore.eshop.dto.CityDTO;
import com.egustore.eshop.model.City;

import java.util.List;

public interface CityService {

    City createCity(CityDTO CityDTO);

    City getCityById(int id);

    List<City> getAllCitys();

    City updateCity(int id,
                    CityDTO CityDTO);

    void deleteCity(int id);
}
