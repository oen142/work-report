package com.wani.workreport.report.member.domain;

import com.wani.workreport.member.domain.Member;
import com.wani.workreport.member.domain.Role;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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

    private Member worker;
    private Member owner;

    @BeforeEach
    void setUp() {
        worker = Member.ofWorker(WORKER_NAME, WORKER_PASSWORD, WORKER_PHONE_NUMBER);
        owner = Member.ofOwner(OWNER_NAME, OWNER_PASSWORD, OWNER_PHONE_NUMBER);
    }

    @DisplayName("작업자 회원이 생성되는걸 확인한다.")
    @Test
    void getMembers() {

        assertThat(worker.getName()).isEqualTo("작업자");
        assertThat(worker.getPassword()).isEqualTo("workerpassword");
        assertThat(worker.getPhoneNumber()).isEqualTo("010-0000-0000");
        assertThat(worker.getRole()).isEqualTo(Role.WORKER);
    }

    @DisplayName("사업자 회원이 생성되는걸 확인한다.")
    @Test
    void getOwners() {
        assertThat(owner.getName()).isEqualTo("비즈니스");
        assertThat(owner.getPassword()).isEqualTo("ownerpassword");
        assertThat(owner.getPhoneNumber()).isEqualTo("010-1111-1111");
        assertThat(owner.getRole()).isEqualTo(Role.OWNER);
    }

    @DisplayName("회원의 정보를 수정할 수 있다.")
    @Test
    void updateMemberInfo() {
        owner.updateInfo("비즈니스업데이트", "010-2222-2222");

        assertThat(owner.getName()).isEqualTo("비즈니스업데이트");
        assertThat(owner.getPassword()).isEqualTo("ownerpassword");
        assertThat(owner.getPhoneNumber()).isEqualTo("010-2222-2222");
        assertThat(owner.getRole()).isEqualTo(Role.OWNER);
    }

    @DisplayName("회원의 비밀번호를 수정할 수 있다.")
    @Test
    void updateMemberPassword() {
        owner.updatePassword("updatepassword");
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
