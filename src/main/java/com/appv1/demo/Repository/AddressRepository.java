package com.appv1.demo.Repository;

import com.appv1.demo.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    Address findAddressByIdAddress(Integer id_address);
}
