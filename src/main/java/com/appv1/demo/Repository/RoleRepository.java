package com.appv1.demo.Repository;

import com.appv1.demo.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findRoleByRole(String role);
}
