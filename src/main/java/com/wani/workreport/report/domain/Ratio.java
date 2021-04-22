package com.wani.workreport.report.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Ratio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ratio_id")
    private Long id;

    private double rate;

    public static Ratio valueOf(double rate) {
        return new Ratio(rate);
    }

    Ratio(double rate) {
        this(null, rate);
    }

    Ratio(Long id, double rate) {
        this.id = id;
        this.rate = rate;
    }

    public Money of(Money price) {
        return price.times(rate);
    }

    public double getRate() {
        return rate;
    }
}
