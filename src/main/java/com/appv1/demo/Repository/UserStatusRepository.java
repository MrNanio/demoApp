package com.appv1.demo.Repository;

import com.appv1.demo.Entity.Role;
import com.appv1.demo.Entity.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserStatusRepository extends JpaRepository<UserStatus, Integer>{

       UserStatus findUserStatusByIdUserStatus(Integer id_user_status);
}
