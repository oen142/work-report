package com.wani.workreport.member.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@Getter
public class PhoneNumber {


    private String first;
    private String middle;
    private String last;

    public PhoneNumber(String first, String middle, String last) {
        this.first = first;
        this.middle = middle;
        this.last = last;
    }

}
