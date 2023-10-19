package com.spring.microservice.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.microservice.entity.PersonProfile;

@Repository
public interface PersonProfileRepository extends JpaRepository<PersonProfile,String> {
        Page<PersonProfile> findByPersonId(String personId, Pageable pageable);

        //   @Query(value = "SELECT * FROM SSC_PERSONPROFILE WHERE PERSON_ID LIKE %:personId%",nativeQuery = true)
        Page<PersonProfile> findByPersonIdContaining(String personId, Pageable pageable);

        @Query(value = "SELECT * FROM SSC_PERSONPROFILE WHERE PERSON_ID LIKE %:personId% AND ROWNUM <= :size",nativeQuery = true)
        List<PersonProfile> findByPersonIdContainingNoPaging(String personId,Integer size);

        PersonProfile findByCisNo(String cisNo);
}
