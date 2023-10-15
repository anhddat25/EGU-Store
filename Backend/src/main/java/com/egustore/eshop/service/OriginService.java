package com.egustore.eshop.service;

import com.egustore.eshop.dto.OriginDTO;
import com.egustore.eshop.model.Origins;

import java.util.List;

public interface OriginService {

    Origins createOrigin(OriginDTO originDTO);

    Origins getOriginById(int id);

    List<Origins> getAllOrigins();

    Origins updateOrigins(int id, OriginDTO originDTO);

    void deleteOrigins(int id);
}
