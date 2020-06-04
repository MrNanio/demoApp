package com.appv1.demo.Repository;

import com.appv1.demo.Entity.CompanyStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyStatusRepository extends JpaRepository<CompanyStatus, Integer> {
}
