package com.egustore.eshop.service;

import com.egustore.eshop.dto.OriginDTO;
import com.egustore.eshop.model.Origin;

import java.util.List;

public interface OriginService {

    Origin createOrigin(OriginDTO originDTO);

    Origin getOriginById(int id);

    List<Origin> getAllOrigins();

    Origin updateOrigins(int id, OriginDTO originDTO);

    void deleteOrigins(int id);
}
