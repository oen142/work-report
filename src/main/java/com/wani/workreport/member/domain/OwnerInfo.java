package com.wani.workreport.member.domain;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OwnerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String businessNumber;

    private String companyName;

    private String OwnerName;

    private Address address;

    private LocalDate openDate;

    private String position;

    private String email;

    private String phoneNumber;

    private String faxNumber;
}
