package com.wani.workreport.report.member.domain;

import com.wani.workreport.member.domain.Member;
import com.wani.workreport.member.domain.Role;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("회원 도메인 테스트")
class MemberTest {

    private static final String WORKER_NAME = "작업자";
    private static final String WORKER_PASSWORD = "workerpassword";
    private static final String WORKER_PHONE_NUMBER = "010-0000-0000";

    private static final String OWNER_NAME = "비즈니스";
    private static final String OWNER_PASSWORD = "ownerpassword";
    private static final String OWNER_PHONE_NUMBER = "010-1111-1111";

    @DisplayName("작업자 회원이 생성되는걸 확인한다.")
    @Test
    void getMembers() {
        Member member = Member.ofWorker(WORKER_NAME, WORKER_PASSWORD, WORKER_PHONE_NUMBER);

        assertThat(member.getName()).isEqualTo("작업자");
        assertThat(member.getPassword()).isEqualTo("workerpassword");
        assertThat(member.getPhoneNumber()).isEqualTo("010-0000-0000");
        assertThat(member.getRole()).isEqualTo(Role.WORKER);
    }

    @DisplayName("사업자 회원이 생성되는걸 확인한다.")
    @Test
    void getOwners() {
        Member member = Member.ofOwner(OWNER_NAME, OWNER_PASSWORD, OWNER_PHONE_NUMBER);


        assertThat(member.getName()).isEqualTo("비즈니스");
        assertThat(member.getPassword()).isEqualTo("ownerpassword");
        assertThat(member.getPhoneNumber()).isEqualTo("010-1111-1111");
        assertThat(member.getRole()).isEqualTo(Role.OWNER);
    }

    @DisplayName("회원의 정보를 수정할 수 있다.")
    @Test
    void updateMemberInfo() {

    }

    @Test
    void throwCreateMemberNameException() {
    }

    @Test
    void throwCreateMemberEmailException() {
    }

    @Test
    void throwCreateMemberAgeException() {
    }

}
