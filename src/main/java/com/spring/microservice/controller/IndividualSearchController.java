package com.spring.microservice.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.spring.microservice.service.IndividualSearchService;

import io.micrometer.core.annotation.Timed;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.spring.microservice.entity.PersonProfile;
import com.spring.microservice.payload.response.MsgResponse;
import com.spring.microservice.repository.PersonProfileRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;


@Timed
@Slf4j
@RestController
@RequestMapping("/individual")
public class IndividualSearchController {

    @Autowired
    private IndividualSearchService individualSearchService;

    @Autowired
    private PersonProfileRepository personProfileRepository;


    @Timed("individual-search.api")
    @GetMapping
    public ResponseEntity<?> individualSearch(
            @RequestParam(required = true) String key,
            @RequestParam(defaultValue = "unique") String type,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
        ) {
        log.info("INDIVIDUAL SEARCH PROFILE CALLED");
        try {
            Map<String, Object> response = new HashMap<>();
            Pageable paging = PageRequest.of(page, size,Sort.by("personId"));
            List<PersonProfile> personProfiles = new ArrayList<>();
            if(!type.equals("nopaging")){
                Page<PersonProfile> pagePersonProfiles = individualSearchService.individualSearch(key,type,paging);
                personProfiles = pagePersonProfiles.getContent();
                response.put("currentPage", pagePersonProfiles.getNumber());
                response.put("totalItems", pagePersonProfiles.getTotalElements());
                response.put("totalPages", pagePersonProfiles.getTotalPages());
            }else{
                personProfiles = personProfileRepository.findByPersonIdContainingNoPaging(key,size);
            }
            
            response.put("datas", personProfiles);
            
            return new ResponseEntity<>(new MsgResponse(personProfiles.isEmpty() ? "Data not found." : "Data found.","200","success",response), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(new MsgResponse(e.getMessage(),"500","error",null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
}
