package com.spring.microservice.service;

import org.springframework.stereotype.Service;


import com.spring.microservice.entity.PersonProfile;
import com.spring.microservice.repository.PersonProfileRepository;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

@Slf4j
@Service
public class IndividualSearchService {

    @Autowired
    PersonProfileRepository personProfileRepository;

    public Page<PersonProfile> individualSearch(String key,String type,Pageable paging) {
        Page<PersonProfile> pagePersonProfiles = new PageImpl<>(Collections.emptyList());
        if(type.equals("unique")){
            pagePersonProfiles = personProfileRepository.findByPersonId(key,paging);
        }else if(type.equals("containing")){
            long startTime = System.nanoTime();
            pagePersonProfiles = personProfileRepository.findByPersonIdContaining(key,paging);
            long endTime   = System.nanoTime();
            double totalTimeSec = (double) (endTime - startTime) / 1_000_000_000;
            log.info("Total time : "+totalTimeSec);
        }
        return pagePersonProfiles;
    }

    public PersonProfile enquiry(String cisNo){
        return personProfileRepository.findByCisNo(cisNo);
    }

}
