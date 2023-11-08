package com.egustore.eshop.controller;

import com.egustore.eshop.dto.RoleDTO;
import com.egustore.eshop.model.Role;
import com.egustore.eshop.service.RoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v0/roles")
@CrossOrigin("*")
public class RoleController {
    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
    //Create category
    @PostMapping("")
    public ResponseEntity<?> createRole(@RequestBody @Valid RoleDTO roleDTO, BindingResult result)
    {
        if(result.hasErrors())
        {
            List<String> errMessage = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errMessage);
        }
        roleService.createRole(roleDTO);
        return ResponseEntity.ok("Create role successfully!");
    }

    //    //Show all categories
    @GetMapping("")
    public ResponseEntity<List<Role>> getAllRole() {
        List<Role> role = roleService.getAllRole();
        return ResponseEntity.ok(role);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<String> updateCustomer(@PathVariable int id,@RequestBody CustomerDTO customerDTO) {
//        customerService.updateCustomer(id,customerDTO);
//        return ResponseEntity.ok("update customer ");
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable int id) {
        roleService.deleteRole(id);
        return ResponseEntity.ok("delete role " + id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable int id) {
        return ResponseEntity.ok(roleService.getRoleById(id));
    }
}
