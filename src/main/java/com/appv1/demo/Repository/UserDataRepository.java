package com.appv1.demo.Repository;

import com.appv1.demo.Entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Integer> {

}
