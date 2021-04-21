package com.wani.workreport.member.domain;

import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {

    private String normal;
    private String detail;
    private String zipcode;

    public Address(String normal, String detail, String zipcode) {
        this.normal = normal;
        this.detail = detail;
        this.zipcode = zipcode;
    }
}
