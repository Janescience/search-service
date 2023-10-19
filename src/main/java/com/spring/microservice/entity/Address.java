
package com.spring.microservice.entity;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name="SSC_ADDRESS")
public class Address {
    
    @Id
    private String addressId;
    private String addresstype;
    private String cisNo;
    private String cifNo;
    private String building;
    private String additionaladdressattribute1;
    private String additionaladdressattribute2;
    private String additionaladdressattribute3;
    private String additionaladdressattribute4;
    private String city;
    private String county;
    private String province;
    private String postalcode;
    private String country;
    private String fulladdress;
    private String systemName;

}
