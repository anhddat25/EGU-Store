package com.egustore.eshop.serviceimpl;

import com.egustore.eshop.dto.RoleDTO;
import com.egustore.eshop.mapper.RoleMapper;
import com.egustore.eshop.model.Role;
import com.egustore.eshop.repository.RoleRepository;
import com.egustore.eshop.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;
    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository,RoleMapper roleMapper)
    {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }
    @Override
    public Role createRole(RoleDTO roleDTO) {
        Role role = RoleMapper.INSTANCE.mapToRole(roleDTO);
        return roleRepository.save(role);
    }

    @Override
    public Role getRoleById(int id){
        return roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }



    @Override
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

//    @Override
//    public Role updateCustomer(int id,
//                                   CustomerDTO customerDTO) {
//        Customer existCustomer = getCustomerById(id);
//        customerMapper.updateCustomerFromDTO(customerDTO, existCustomer);
//        customerRepository.save(existCustomer);
//        return existCustomer;
//    }

    @Override
    public void deleteRole(int id) {

        roleRepository.deleteById(id);
    }
}
