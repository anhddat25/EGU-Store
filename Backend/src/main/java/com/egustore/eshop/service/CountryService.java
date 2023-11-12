package com.egustore.eshop.service;


import com.egustore.eshop.dto.CountryDTO;
import com.egustore.eshop.model.Country;

import java.util.List;

public interface CountryService {

    Country createCountry(CountryDTO CountryDTO);

    Country getCountryById(int id);

    List<Country> getAllCountrys();

    Country updateCountry(int id,
                      CountryDTO CountryDTO);

    void deleteCountry(int id);
}
