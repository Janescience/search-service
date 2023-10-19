package com.spring.microservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.microservice.entity.Occupation;

@Repository
public interface OccupationRepository extends JpaRepository<Occupation,String> {
        List<Occupation> findByCisNo(String cisNo);
}
