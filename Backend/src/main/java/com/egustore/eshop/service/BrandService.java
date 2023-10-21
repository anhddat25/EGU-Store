package com.egustore.eshop.service;


import com.egustore.eshop.dto.BrandDTO;
import com.egustore.eshop.model.Brand;

import java.util.List;

public interface BrandService {

    Brand createBrand(BrandDTO BrandDTO);

    Brand getBrandById(int id);

    List<Brand> getAllBrands();

    Brand updateBrand(int id,
                      BrandDTO BrandDTO);

    void deleteBrand(int id);
}
