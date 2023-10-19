package com.spring.microservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.microservice.entity.DigitalContact;

@Repository
public interface DigitalContactRepository extends JpaRepository<DigitalContact,String> {
        List<DigitalContact> findByCisNo(String cisNo);
}
