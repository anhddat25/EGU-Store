package com.egustore.eshop.service;

import com.egustore.eshop.dto.RoleDTO;
import com.egustore.eshop.model.Role;

import java.util.List;

public interface RoleService {
    Role createRole(RoleDTO roleDTO);

    Role getRoleById(int id);

    List<Role> getAllRole();

    void deleteRole(int id);
}
