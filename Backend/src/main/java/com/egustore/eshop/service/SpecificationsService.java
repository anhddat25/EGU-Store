package com.egustore.eshop.service;

import com.egustore.eshop.dto.SpecificationsDTO;
import com.egustore.eshop.model.Specifications;
import java.util.List;

public interface SpecificationsService {
    Specifications createSpec(SpecificationsDTO specificationsDTO);
    Specifications getSpecById(int id);
    Specifications updateSpec(int id, SpecificationsDTO specifications);
    List<Specifications> getAllSpec();
    void deleteSpec(int id);
//    Integer updateSpecById(SpecificationsDTO specificationsDTO, int id);
}
