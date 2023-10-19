
package com.spring.microservice.entity;


import lombok.Data;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Data
@Entity
@Table(name="SSC_PERSONPROFILE")
public class PersonProfile {
    
    @Id
    private String personId;
    private String cisNo;
    private String cifNo;
    private Long partyid;
    private String titleth;
    private String firstnameth;
    private String middlenameth;
    private String lastnameth;
    private String fullnameth;
    private String fullnameen;
    private String personlastname;
    private String personfirstname;
    private Date legacyflagdeletedate;
    @Transient
    private List<Address> addresses;
    @Transient
    private List<Occupation> occupations;
    @Transient
    private List<Phone> phones;
    @Transient
    private List<DigitalContact> digitalContacts;
}
