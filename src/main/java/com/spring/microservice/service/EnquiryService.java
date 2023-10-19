package com.spring.microservice.service;

import org.springframework.stereotype.Service;


import com.spring.microservice.entity.*;

import com.spring.microservice.repository.AddressRepository;
import com.spring.microservice.repository.DigitalContactRepository;
import com.spring.microservice.repository.OccupationRepository;
import com.spring.microservice.repository.PersonProfileRepository;
import com.spring.microservice.repository.PhoneRepository;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


@Slf4j
@Service
public class EnquiryService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    OccupationRepository occupationRepository;

    @Autowired
    PhoneRepository phoneRepository;

    @Autowired
    DigitalContactRepository digitalContactRepository;

    @Autowired
    PersonProfileRepository personRepository;

    public PersonProfile enquiry(String cisNo){
        PersonProfile personProfile = personRepository.findByCisNo(cisNo);
        if(personProfile != null){

            //Address
            List<Address> addresses = addressRepository.findByCisNo(cisNo);
            personProfile.setAddresses(addresses);

            //Occupation
            List<Occupation> occupations = occupationRepository.findByCisNo(cisNo);
            personProfile.setOccupations(occupations);

            //Phone
            List<Phone> phones = phoneRepository.findByCisNo(cisNo);
            personProfile.setPhones(phones);

            //DigitalContact
            List<DigitalContact> digitalContacts = digitalContactRepository.findByCisNo(cisNo);
            personProfile.setDigitalContacts(digitalContacts);

        }
        return personProfile;
    }

}
