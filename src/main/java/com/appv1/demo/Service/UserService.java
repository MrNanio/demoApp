package com.appv1.demo.Service;

import com.appv1.demo.Entity.Role;
import com.appv1.demo.Entity.User;
import com.appv1.demo.Entity.UserStatus;
import com.appv1.demo.Repository.RoleRepository;
import com.appv1.demo.Repository.UserRepository;
import com.appv1.demo.Repository.UserStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private UserStatusRepository userStatusRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, UserStatusRepository userStatusRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userStatusRepository = userStatusRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findRoleByRole("ADMIN");
        UserStatus userStatus = userStatusRepository.findUserStatusByIdUserStatus(1);
        user.setUserStatus(userStatus);
        user.setUserLevel("1");
        LocalDateTime datetime = LocalDateTime.now();
        user.setCreatedAt(datetime);
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

}