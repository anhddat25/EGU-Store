package com.egustore.eshop.mapper;


import com.egustore.eshop.dto.OriginDTO;
import com.egustore.eshop.dto.TokenDTO;
import com.egustore.eshop.model.Origin;
import com.egustore.eshop.model.Tokens;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TokenMapper {
    TokenMapper INSTANCE = Mappers.getMapper(TokenMapper.class);
    Tokens mapToTokens(TokenDTO tokenDTO);
    TokenDTO mapToTokenDto(Tokens tokens );
    @Mapping(target = "id", ignore = true)
    void updateTokenFromDTO(TokenDTO tokenDTO, @MappingTarget Tokens tokens);
}
