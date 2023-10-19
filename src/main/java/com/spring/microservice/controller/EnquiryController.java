package com.spring.microservice.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.spring.microservice.service.EnquiryService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.spring.microservice.entity.PersonProfile;
import com.spring.microservice.payload.response.MsgResponse;

@Slf4j
@RestController
@RequestMapping("/enquiry")
public class EnquiryController {

    @Autowired
    private EnquiryService enquiryService;

    @GetMapping("/{cisNo}")
    public ResponseEntity<?> enquiry(@PathVariable String cisNo) {
        log.info("ENQUIRY PROFILE CALLED");
        try {
            PersonProfile personProfile = enquiryService.enquiry(cisNo);
            return new ResponseEntity<>(new MsgResponse(personProfile == null ? "Data not found." : "Data found.","200","success",personProfile), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(new MsgResponse(e.getMessage(),"500","error",null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
}
