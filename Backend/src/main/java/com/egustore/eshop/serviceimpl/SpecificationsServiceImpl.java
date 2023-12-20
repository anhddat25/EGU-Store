package com.egustore.eshop.serviceimpl;

import com.egustore.eshop.dto.SpecificationsDTO;
import com.egustore.eshop.mapper.SpecificationsMapper;
import com.egustore.eshop.model.Specifications;
import com.egustore.eshop.repository.SpecificationsRepository;
import com.egustore.eshop.service.SpecificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecificationsServiceImpl implements SpecificationsService {
    private final SpecificationsRepository specificationsReposity;
    private final SpecificationsMapper specificationsMapper;

    @Autowired
    public SpecificationsServiceImpl(SpecificationsRepository specificationsReposity, SpecificationsMapper specificationsMapper)
    {
        this.specificationsReposity = specificationsReposity;
        this.specificationsMapper = specificationsMapper;
    }

    @Override
    public Specifications createSpec(SpecificationsDTO specificationsDTO) {
        Specifications specifications = specificationsMapper.mapToSpec(specificationsDTO);
        return specificationsReposity.save(specifications);
    }

    @Override
    public Specifications getSpecById(int id){
        return specificationsReposity.findById(id)
                .orElseThrow(() -> new RuntimeException("Specifications not found"));
    }

    @Override
    public Specifications updateSpec(int id, SpecificationsDTO specificationsDTO) {
        Specifications existSpecifications = getSpecById(id);
        specificationsMapper.updateSpecFromDTO(specificationsDTO, existSpecifications);
        specificationsReposity.save(existSpecifications);
        return existSpecifications;
    }

    @Override
    public Specifications getByProduct(int products) {
        return specificationsReposity.findByProductId(products);
    }

    @Override
    public List<Specifications> getAllSpec() {
        return specificationsReposity.findAll();
    }

    @Override
    public void deleteSpec(int id) {

        specificationsReposity.deleteById(id);
    }

//    @Override
//    public Integer updateSpecById(SpecificationsDTO specificationsDTO, int id) {
//        return specificationsReposity.updateSpecById(specificationsDTO, id);
//    }
}
