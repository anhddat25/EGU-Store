package com.egustore.eshop.serviceimpl;


import com.egustore.eshop.dto.CountryDTO;
import com.egustore.eshop.mapper.CountryMapper;
import com.egustore.eshop.model.Country;
import com.egustore.eshop.repository.CountryRepository;
import com.egustore.eshop.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository, CountryMapper countryMapper)
    {
        this.countryRepository = countryRepository;
        this.countryMapper = countryMapper;
    }

    @Override
    public Country createCountry(CountryDTO CountryDTO) {
        Country Country = countryMapper.mapToCountry(CountryDTO);
        return countryRepository.save(Country);
    }

    @Override
    public Country getCountryById(int id){
        return countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found"));
    }



    @Override
    public List<Country> getAllCountrys() {
        return countryRepository.findAll();
    }

    @Override
    public Country updateCountry(int id,
                             CountryDTO CountryDTO) {
        Country existCountry = getCountryById(id);
        countryMapper.updateCountryFromDTO(CountryDTO, existCountry);
        countryRepository.save(existCountry);
        return existCountry;
    }

    @Override
    public void deleteCountry(int id) {

        countryRepository.deleteById(id);
    }

}
