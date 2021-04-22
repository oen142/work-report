package com.wani.workreport.report.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Function;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Money {

    public static final Money ZERO = Money.wons(0);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "money_id")
    private Long id;

    private BigDecimal amount;

    public static Money wons(long amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public static Money wons(double amount) {
        return new Money(BigDecimal.valueOf(amount));
    }


    public static <T> Money sum(Collection<T> bags, Function<T, Money> monetary) {
        return bags.stream()
                .map(bag -> monetary.apply(bag))
                .reduce(Money.ZERO, Money::plus);
    }

    Money(BigDecimal amount) {
        this(null, amount);
    }

    Money(Long id, BigDecimal amount) {
        this.id = id;
        this.amount = amount;
    }

    public Money plus(Money amount) {
        return new Money(this.amount.add(amount.amount));
    }

    public Money minus(Money amount) {
        return new Money(this.amount.subtract(amount.amount));
    }

    public Money times(double percent) {
        return new Money(this.amount.multiply(BigDecimal.valueOf(percent)));
    }

    public Money divide(double divisor) {
        return new Money(amount.divide(BigDecimal.valueOf(divisor)));
    }

    public boolean isLessThan(Money other) {
        return amount.compareTo(other.amount) < 0;
    }

    public boolean isGreaterThanOrEqual(Money other) {
        return amount.compareTo(other.amount) >= 0;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Long longValue() {
        return amount.longValue();
    }

    public Double doubleValue() {
        return amount.doubleValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(getId(), money.getId()) && Objects.equals(getAmount(), money.getAmount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAmount());
    }

    @Override
    public String toString() {
        return "Money{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }
}
