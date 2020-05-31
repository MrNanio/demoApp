package com.appv1.demo.Service;

import com.appv1.demo.Entity.Role;
import com.appv1.demo.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private RoleRepository roleRepository;
    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    public Role save(Role role){
        return roleRepository.save(role);
    }

}
