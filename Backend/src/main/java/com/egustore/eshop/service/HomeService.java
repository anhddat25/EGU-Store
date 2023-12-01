package com.egustore.eshop.service;

import com.egustore.eshop.dto.HomeDTO;

import java.util.List;

public interface HomeService {
    List<HomeDTO> getAllListWithRating();
}
