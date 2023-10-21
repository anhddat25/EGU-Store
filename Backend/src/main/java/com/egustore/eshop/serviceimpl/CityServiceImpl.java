package com.egustore.eshop.serviceimpl;


import com.egustore.eshop.dto.CityDTO;
import com.egustore.eshop.mapper.CityMapper;
import com.egustore.eshop.model.City;
import com.egustore.eshop.repository.CityRepository;
import com.egustore.eshop.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository, CityMapper cityMapper)
    {
        this.cityRepository = cityRepository;
        this.cityMapper = cityMapper;
    }

    @Override
    public City createCity(CityDTO CityDTO) {
        City City = cityMapper.mapToCity(CityDTO);
        return cityRepository.save(City);
    }

    @Override
    public City getCityById(int id){
        return cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found"));
    }



    @Override
    public List<City> getAllCitys() {
        return cityRepository.findAll();
    }

    @Override
    public City updateCity(int id,
                             CityDTO CityDTO) {
        City existCity = getCityById(id);
        cityMapper.updateCityFromDTO(CityDTO, existCity);
        cityRepository.save(existCity);
        return existCity;
    }

    @Override
    public void deleteCity(int id) {

        cityRepository.deleteById(id);
    }

}
