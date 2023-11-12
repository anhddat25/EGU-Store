package com.egustore.eshop.serviceimpl;


import com.egustore.eshop.dto.TokenDTO;
import com.egustore.eshop.mapper.TokenMapper;
import com.egustore.eshop.model.Tokens;
import com.egustore.eshop.repository.TokenRepository;
import com.egustore.eshop.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TokenServiceImpl implements TokenService {
    private final TokenRepository tokenRepository;
    private final TokenMapper tokenMapper;

    @Autowired
    public TokenServiceImpl(TokenRepository tokenRepository, TokenMapper tokenMapper)
    {
        this.tokenRepository = tokenRepository;
        this.tokenMapper = tokenMapper;
    }

    @Override
    public Tokens createToken(TokenDTO TokenDTO) {
        Tokens Token = tokenMapper.mapToTokens(TokenDTO);
        return tokenRepository.save(Token);
    }

    @Override
    public Tokens getTokenById(int id){
        return tokenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Token not found"));
    }



    @Override
    public List<Tokens> getAllTokens() {
        return tokenRepository.findAll();
    }

    @Override
    public Tokens updateToken(int id,
                             TokenDTO TokenDTO) {
        Tokens existToken = getTokenById(id);
        tokenMapper.updateTokenFromDTO(TokenDTO, existToken);
        tokenRepository.save(existToken);
        return existToken;
    }

    @Override
    public void deleteToken(int id) {
        tokenRepository.deleteById(id);
    }

}
