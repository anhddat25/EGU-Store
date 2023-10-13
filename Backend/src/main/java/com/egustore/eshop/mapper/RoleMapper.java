package com.egustore.eshop.mapper;

import com.egustore.eshop.dto.RoleDTO;
import com.egustore.eshop.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
    Role mapToRole(RoleDTO roleDTO);
    RoleDTO mapToRoleDTO(Role Role);
}
