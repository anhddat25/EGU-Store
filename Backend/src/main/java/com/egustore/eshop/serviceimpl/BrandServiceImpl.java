package com.egustore.eshop.serviceimpl;


import com.egustore.eshop.dto.BrandDTO;
import com.egustore.eshop.mapper.BrandMapper;
import com.egustore.eshop.model.Brand;
import com.egustore.eshop.repository.BrandRepository;
import com.egustore.eshop.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository, BrandMapper brandMapper)
    {
        this.brandRepository = brandRepository;
        this.brandMapper = brandMapper;
    }

    @Override
    public Brand createBrand(BrandDTO BrandDTO) {
        Brand Brand = brandMapper.mapToBrand(BrandDTO);
        return brandRepository.save(Brand);
    }

    @Override
    public Brand getBrandById(int id){
        return brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brand not found"));
    }



    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public Brand updateBrand(int id,
                                 BrandDTO BrandDTO) {
        Brand existBrand = getBrandById(id);
        brandMapper.updateBrandFromDTO(BrandDTO, existBrand);
        brandRepository.save(existBrand);
        return existBrand;
    }

    @Override
    public void deleteBrand(int id) {
        brandRepository.deleteById(id);
    }

}
