package com.appv1.demo.Repository;


import com.appv1.demo.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    Company findCompanyByIdCompany(Integer id_company);
}
