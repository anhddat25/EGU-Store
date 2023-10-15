package com.egustore.eshop.service;

import com.egustore.eshop.dto.BrandDTO;
import com.egustore.eshop.model.Brand;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BrandService {

    Brand createBrand(BrandDTO brandDTO);
    Brand getBrandById(int id);
    Brand updateBrand(int id, BrandDTO brandDTO);
    List<Brand> getAllBrands();
    void deleteBrand(int id);
}
