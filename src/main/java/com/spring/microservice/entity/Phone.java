
package com.spring.microservice.entity;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name="SSC_PHONE")
public class Phone {
    
    @Id
    private String phoneId;
    private String cisNo;
    private String cifNo;
    private String phonenumbertype;
    private String phonenumbercountrycode;
    private String phonenumber;
    private String extensionnumber;
    private String validphoneflag;

}
