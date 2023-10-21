package com.egustore.eshop.service;


import com.egustore.eshop.dto.TokenDTO;
import com.egustore.eshop.model.Tokens;

import java.util.List;

public interface TokenService {

    Tokens createToken(TokenDTO TokenDTO);

    Tokens getTokenById(int id);

    List<Tokens> getAllTokens();

    Tokens updateToken(int id,
                       TokenDTO TokenDTO);

    void deleteToken(int id);
}
