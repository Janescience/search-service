package com.spring.microservice.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.spring.microservice.entity.PersonProfile;
import com.spring.microservice.repository.PersonProfileRepository;

import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import io.micrometer.core.instrument.Counter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

@Slf4j
@Service
@Component
public class IndividualSearchService {

    private Counter individualSearchCounter = null;
    private AtomicInteger activeUsers = null;

    @Autowired
    PersonProfileRepository personProfileRepository;

    public IndividualSearchService(CompositeMeterRegistry meterRegistry) {
        individualSearchCounter = meterRegistry.counter("order.individual.searchs");
        activeUsers = meterRegistry.gauge("number.of.active.users",new AtomicInteger(0));
        Random random = new Random();
        activeUsers.set(random.nextInt());
    }

    public Page<PersonProfile> individualSearch(String key,String type,Pageable paging) {
        Page<PersonProfile> pagePersonProfiles = new PageImpl<>(Collections.emptyList());
        if(type.equals("unique")){
            pagePersonProfiles = personProfileRepository.findByPersonId(key,paging);
        }else if(type.equals("containing")){
            pagePersonProfiles = personProfileRepository.findByPersonIdContaining(key,paging);
        }
        individualSearchCounter.increment();
        return pagePersonProfiles;
    }

}
