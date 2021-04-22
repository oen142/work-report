package com.wani.workreport.report.member.domain;

import com.wani.workreport.member.domain.Member;
import com.wani.workreport.member.domain.PhoneNumber;
import com.wani.workreport.member.domain.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("회원 도메인 테스트")
class MemberTest {

    private static final String WORKER_NAME = "작업자";
    private static final String WORKER_PASSWORD = "workerpassword";
    private static final String WORKER_PHONE_NUMBER_FIRST = "010";
    private static final String WORKER_PHONE_NUMBER_MIDDLE = "0000";
    private static final String WORKER_PHONE_NUMBER_LAST = "0000";

    private static final String OWNER_NAME = "비즈니스";
    private static final String OWNER_PASSWORD = "ownerpassword";
    private static final String OWNER_PHONE_NUMBER_FIRST = "010";
    private static final String OWNER_PHONE_NUMBER_MIDDLE = "1111";
    private static final String OWNER_PHONE_NUMBER_LAST = "1111";

    private Member worker;
    private Member owner;
    private PhoneNumber workerPhoneNumber;
    private PhoneNumber ownerPhoneNumber;

    @BeforeEach
    void setUp() {
        workerPhoneNumber = new PhoneNumber(WORKER_PHONE_NUMBER_FIRST, WORKER_PHONE_NUMBER_MIDDLE, WORKER_PHONE_NUMBER_LAST);
        ownerPhoneNumber = new PhoneNumber(OWNER_PHONE_NUMBER_FIRST, OWNER_PHONE_NUMBER_MIDDLE, OWNER_PHONE_NUMBER_LAST);
        worker = Member.ofWorker(WORKER_NAME, WORKER_PASSWORD, workerPhoneNumber);
        owner = Member.ofOwner(OWNER_NAME, OWNER_PASSWORD, ownerPhoneNumber);
    }

    @DisplayName("작업자 회원이 생성되는걸 확인한다.")
    @Test
    void getMembers() {

        assertThat(worker.getUsername()).isEqualTo("작업자");
        assertThat(worker.getPassword()).isEqualTo("workerpassword");
        assertThat(worker.getPhoneNumber()).isEqualTo( new PhoneNumber("010","0000","0000"));
        assertThat(worker.getRole()).isEqualTo(Role.WORKER);
    }

    @DisplayName("사업자 회원이 생성되는걸 확인한다.")
    @Test
    void getOwners() {
        assertThat(owner.getUsername()).isEqualTo("비즈니스");
        assertThat(owner.getPassword()).isEqualTo("ownerpassword");
        assertThat(owner.getPhoneNumber()).isEqualTo( new PhoneNumber("010","1111","1111"));
        assertThat(owner.getRole()).isEqualTo(Role.OWNER);
    }

    @DisplayName("회원의 정보를 수정할 수 있다.")
    @Test
    void updateMemberInfo() {
        owner.updateInfo("비즈니스업데이트", new PhoneNumber("010","2222","2222"));

        assertThat(owner.getUsername()).isEqualTo("비즈니스업데이트");
        assertThat(owner.getPassword()).isEqualTo("ownerpassword");
        assertThat(owner.getPhoneNumber()).isEqualTo(new PhoneNumber("010","2222","2222"));
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
