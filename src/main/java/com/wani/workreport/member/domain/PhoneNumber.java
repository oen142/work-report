package com.wani.workreport.member.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.util.Objects;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return Objects.equals(getFirst(), that.getFirst()) && Objects.equals(getMiddle(), that.getMiddle()) && Objects.equals(getLast(), that.getLast());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirst(), getMiddle(), getLast());
    }
}
