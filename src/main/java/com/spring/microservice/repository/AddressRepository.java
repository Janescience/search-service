package com.spring.microservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.microservice.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,String> {
        List<Address> findByCisNo(String cisNo);
}
