package com.wani.workreport.report.member.acceptance;

import com.wani.workreport.auth.dto.TokenResponse;
import com.wani.workreport.member.domain.PhoneNumber;
import com.wani.workreport.member.domain.Role;
import com.wani.workreport.member.dto.MemberRequest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

public class MemberStep {

    public static final String USERNAME_FIELD = "username";
    public static final String PASSWORD_FIELD = "password";
    public static final String PHONE_NUMBER_FIELD = "010-0000-0000";
    public static final String EMAIL_FIELD = "email@naver.com";

    public static TokenResponse 로그인_되어_있음(String username, String password) {
        ExtractableResponse<Response> response = 로그인_요청(username, password);
        return response.as(TokenResponse.class);
    }

    public static ExtractableResponse<Response> 로그인_요청(String username,
                                                       String password) {

        Map<String, String> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);

        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(params)
                .when().post("/login/token")
                .then().log().all()
                .statusCode(HttpStatus.OK.value()).extract();
    }

    public static ExtractableResponse<Response> 회원_생성_요청(String username, String password,
                                                         PhoneNumber phoneNumber, String roleType) {

        MemberRequest params = new MemberRequest(username, password, phoneNumber, roleType);

        return RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(params)
                .when().post("/members")
                .then().log().all().extract();
    }
}
