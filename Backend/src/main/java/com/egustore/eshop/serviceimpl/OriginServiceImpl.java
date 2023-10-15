package com.egustore.eshop.serviceimpl;

import com.egustore.eshop.dto.OriginDTO;
import com.egustore.eshop.mapper.OriginMapper;
import com.egustore.eshop.model.Origins;
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
    public Origins createOrigin(OriginDTO originDTO) {
        Origins origins = originMapper.mapToOrigins(originDTO);
        return originRepository.save(origins);
    }

    @Override
    public Origins getOriginById(int id){
        return originRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Origin not found"));
    }



    @Override
    public List<Origins> getAllOrigins() {
        return originRepository.findAll();
    }

    @Override
    public Origins updateOrigins(int id,
                              OriginDTO originDTO) {
        Origins existOrigins = getOriginById(id);
        originMapper.updateOriginFromDTO(originDTO, existOrigins);
        originRepository.save(existOrigins);
        return existOrigins;
    }

    @Override
    public void deleteOrigins(int id) {

        originRepository.deleteById(id);
    }
}
