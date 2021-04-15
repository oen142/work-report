package com.wani.workreport.member.domain;

import com.wani.workreport.common.BaseEntity;
import com.wani.workreport.member.exception.InvalidMemberInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(length = 30)
    private String name;

    @Column(length = 255)
    private String email;

    @Lob
    private String password;

    private Integer age;

    public Member(String name, String email, String password, int age) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public static Member of(String name, String email, String password, int age) {
        validateName(name);
        validateAge(age);
        validateEmail(email);

        return new Member(name, email, password, age);
    }

    private static void validateName(String name) {

    }

    private static void validateEmail(String email) {

    }

    private static void validateAge(int age) {
        if(age < 8 || age > 70){
            throw new InvalidMemberInfo("나이가 적절치 않습니다.");
        }
    }

    public void updateInfo(String name, String email, String password, int age) {
        validateName(name);
        validateAge(age);
        validateEmail(email);

        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
    }
}
