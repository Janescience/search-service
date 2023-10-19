
package com.spring.microservice.entity;

import lombok.Data;

import java.util.Date;

import jakarta.persistence.*;

@Data
@Entity
@Table(name="SSC_OCCUPATION")
public class Occupation {
    
    @Id
    private String occupationId;
    private String cisNo;
    private String cifNo;
    private String customerdefinition;
    private String occupation;
    private String businesstype;
    private String workofficename;
    private String workaddress;
    private String occupationstatus;
    private Date occupationinfocapturedate;
    private String recordname;
    private String personprofileId;
    private String mainoccupationflag;

}
