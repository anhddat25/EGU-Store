package com.egustore.eshop.serviceimpl;

import com.egustore.eshop.dto.BrandDTO;
import com.egustore.eshop.mapper.BrandMapper;
import com.egustore.eshop.model.Brand;
import com.egustore.eshop.repository.BrandRepository;
import com.egustore.eshop.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    public BrandServiceImpl(BrandRepository brandRepository, BrandMapper brandMapper) {
        this.brandRepository = brandRepository;
        this.brandMapper = brandMapper;
    }


    @Override
    public Brand createBrand(BrandDTO brandDTO) {
        Brand brand = brandMapper.mapToBrand(brandDTO);
        return brandRepository.save(brand);
    }

    @Override
    public Brand getBrandById(int id) {
         return brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brand not found"));
    }

    @Override
    public Brand updateBrand(int id, BrandDTO brandDTO) {
        Optional<Brand> brandOpt = brandRepository.findById(id);
        brandOpt.ifPresent(brand -> {
            brandMapper.updateBrandFromDTO(brandDTO, brand);
            brandRepository.save(brand);
        });
        return brandOpt.orElseThrow(() -> new RuntimeException("Brand not found"));
    }

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public void deleteBrand(int id) {
        brandRepository.deleteById(id);
    }
}
