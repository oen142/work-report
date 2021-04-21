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

    @Column(name = "phone_number")
    private String phoneNumber;

    @Lob
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Member(Long id, String name, String phoneNumber, String password,
        Role role) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
    }

    public Member(String name, String phoneNumber, String password,
        Role role) {
        this(null, name, phoneNumber, password, role);
    }

    public static Member ofWorker(String name, String password, String phoneNumber) {
        validateName(name);
        return new Member(name, phoneNumber, password, Role.WORKER);
    }

    public static Member ofOwner(String name, String password, String phoneNumber) {
        validateName(name);

        return new Member(name, phoneNumber, password, Role.OWNER);
    }

    public void updateInfo(String name, String phoneNumber) {
        validateName(name);

        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    private static void validateName(String name) {

    }

    public void updatePassword(String password) {
        validatePassword(password);
        this.password = password;
    }

    private void validatePassword(String password) {

    }
}
