
package com.spring.microservice.entity;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name="SSC_DIGITALCONTACT")
public class DigitalContact {
    
    @Id
    @Column(name = "DIGITALCONTACT_ID")
    private String digitalcontactId;
    private String cisNo;
    private String cifNo;
    private String digitalcontacttype;

    @Column(name = "DIGITALCONTACTID")
    private String digitalcontactname;

}
