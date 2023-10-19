package com.spring.microservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.microservice.entity.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone,String> {
        List<Phone> findByCisNo(String cisNo);
}
