package com.wani.workreport.report.member.acceptance;

import com.wani.workreport.AcceptanceTest;
import com.wani.workreport.member.domain.PhoneNumber;
import com.wani.workreport.member.domain.Role;
import com.wani.workreport.member.dto.MemberRequest;
import com.wani.workreport.member.dto.MemberResponse;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.*;

@DisplayName("회원가입 인수 테스트")
public class MemberAcceptance extends AcceptanceTest {

    public static final String USERNAME = "worker";
    public static final String PASSWORD = "password";
    public static final String NEW_PASSWORD = "newpassword";
    public static final PhoneNumber PHONE_NUMBER = new PhoneNumber("010", "1111", "1111");
    public static final PhoneNumber NEW_PHONE_NUMBER = new PhoneNumber("010", "2222", "2222");
    public static final Role WORKER = Role.WORKER;
    public static final Role OWNER = Role.OWNER;

    @DisplayName("회원가입을 한다.")
    @Test
    void createMember() {
        ExtractableResponse<Response> response = MemberStep.회원_생성_요청(USERNAME, PASSWORD, PHONE_NUMBER, WORKER.name());


        회원_생성됨(response);

    }

    private void 회원_생성됨(ExtractableResponse<Response> response) {
        MemberResponse memberResponse = response.as(MemberResponse.class);


        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(memberResponse.getId()).isNotNull();
        assertThat(memberResponse.getPhoneNumber()).isEqualTo(PHONE_NUMBER);
        assertThat(memberResponse.getName()).isEqualTo(USERNAME);
        assertThat(memberResponse.getRoleName()).isEqualTo(WORKER.name());
    }
}
