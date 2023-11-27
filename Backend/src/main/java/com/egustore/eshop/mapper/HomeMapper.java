package com.egustore.eshop.mapper;

import com.egustore.eshop.dto.HomeDTO;
import com.egustore.eshop.model.CustomerReport;
import com.egustore.eshop.model.Home;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HomeMapper {
    HomeMapper INSTANCE = Mappers.getMapper(HomeMapper.class);

    HomeDTO toDTO(Home home);

    List<HomeDTO> toDTOList(List<Home> homeList);

}
