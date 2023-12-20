package com.egustore.eshop.serviceimpl;

import com.egustore.eshop.dto.HomeDTO;
import com.egustore.eshop.mapper.HomeMapper;
import com.egustore.eshop.repository.HomeRepository;
import com.egustore.eshop.service.HomeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    private final HomeRepository homeRepository;

    private final HomeMapper homeMapper;

    public HomeServiceImpl(HomeRepository homeRepository, HomeMapper homeMapper) {
        this.homeRepository = homeRepository;
        this.homeMapper = homeMapper;
    }

    @Override
    public List<HomeDTO> getAllListWithRating() {
        return homeMapper.toDTOList(homeRepository.getAllListWithRating());
    }
}
