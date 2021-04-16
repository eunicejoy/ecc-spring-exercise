package com.mycompany.app.SpringExercise.controller;

import com.mycompany.app.SpringExercise.ResourceNotFoundException;
import com.mycompany.app.SpringExercise.core.model.Role;
import com.mycompany.app.SpringExercise.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/roles")
    public List<Role> listRoles(){
        return roleRepository.findAll();
    }

    @PostMapping("/roles")
    public Role addRole(@Valid @RequestBody Role role){
        return roleRepository.save(role);
    }

    @PutMapping("/roles/{id}")
    public Role updateRole(@PathVariable(value = "id") Integer roleId, @Valid @RequestBody Role roleDetail){
        Role role = roleRepository.findById(roleId)
        .orElseThrow(()->new ResourceNotFoundException("Role with " + roleId + " id does not exist."));

        if(roleDetail.getRoleName() == ""){
            role.setRoleName(role.getRoleName());
        } else{
            role.setRoleName(roleDetail.getRoleName());
        }

        Role updatedRole = roleRepository.save(role);
        return updatedRole;
    }

    @DeleteMapping("roles/{id}")
    public String deleteRole(@PathVariable(value = "id") Integer roleId){
        Role role = roleRepository.findById(roleId)
                .orElseThrow(()-> new ResourceNotFoundException("Role with " + roleId + " id does not exist."));

        roleRepository.delete(role);

        return "Role with id " + roleId + " has been deleted.";
    }


}
