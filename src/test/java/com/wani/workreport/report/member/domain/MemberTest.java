package com.wani.workreport.report.member.domain;

import com.wani.workreport.member.domain.Member;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemberTest {

    @Test
    void getMembers() {
        Member member = Member.of("김종완", "test@naver.com", "password", 27);

        assertThat(member.getName()).isEqualTo("김종완");
        assertThat(member.getEmail()).isEqualTo("test@naver.com");
        assertThat(member.getPassword()).isEqualTo("password");
        assertThat(member.getAge()).isEqualTo(27);
    }

    @Test
    void updateMemberInfo() {
        Member member = Member.of("김종완", "test@naver.com", "password", 27);

        member.updateInfo("이기자", "update@naver.com", "updatepassword", 25);

        assertThat(member.getName()).isEqualTo("이기자");
        assertThat(member.getEmail()).isEqualTo("update@naver.com");
        assertThat(member.getPassword()).isEqualTo("updatepassword");
        assertThat(member.getAge()).isEqualTo(25);
    }

    @Test
    void throwCreateMemberNameException() {
        assertThatThrownBy(() -> Member.of("김종완", "test@naver.com", "password", 27));
    }

    @Test
    void throwCreateMemberEmailException() {
        assertThatThrownBy(() -> Member.of("김종완", "test@naver.com", "password", 27));
    }

    @Test
    void throwCreateMemberAgeException() {
        assertThatThrownBy(() -> Member.of("김종완", "test@naver.com", "password", 27));
    }

}
