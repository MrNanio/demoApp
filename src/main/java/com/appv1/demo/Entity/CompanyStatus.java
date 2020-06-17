package com.appv1.demo.Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CompanyStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCompanyStatus;

    @Column(length = 15, nullable = false)
    private String statusName;

    @OneToMany(mappedBy = "companyStatus", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Company> companies= new HashSet<>();

    public Integer getIdCompanyStatus() {
        return idCompanyStatus;
    }

    public void setIdCompanyStatus(Integer idCompanyStatus) {
        this.idCompanyStatus = idCompanyStatus;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }
}
