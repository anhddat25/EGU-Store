package com.egustore.eshop.serviceimpl;

import com.egustore.eshop.dto.OriginDTO;
import com.egustore.eshop.mapper.OriginMapper;
import com.egustore.eshop.model.Origin;
import com.egustore.eshop.repository.OriginRepository;

import com.egustore.eshop.service.OriginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OriginServiceImpl implements OriginService {
    private final OriginRepository originRepository;
    private final OriginMapper originMapper;

    @Autowired
    public OriginServiceImpl(OriginRepository  originRepository, OriginMapper originMapper)
    {
        this.originRepository = originRepository;
        this.originMapper = originMapper;
    }

    @Override
    public Origin createOrigin(OriginDTO originDTO) {
        Origin origin = originMapper.mapToOrigins(originDTO);
        return originRepository.save(origin);
    }

    @Override
    public Origin getOriginById(int id){
        return originRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Origin not found"));
    }



    @Override
    public List<Origin> getAllOrigins() {
        return originRepository.findAll();
    }

    @Override
    public Origin updateOrigins(int id,
                                OriginDTO originDTO) {
        Origin existOrigin = getOriginById(id);
        originMapper.updateOriginFromDTO(originDTO, existOrigin);
        originRepository.save(existOrigin);
        return existOrigin;
    }

    @Override
    public void deleteOrigins(int id) {

        originRepository.deleteById(id);
    }
}
