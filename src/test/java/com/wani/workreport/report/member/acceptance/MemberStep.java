package com.wani.workreport.report.member.acceptance;

import com.wani.workreport.auth.dto.TokenResponse;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public class MemberStep {

    public static final String USERNAME_FIELD = "username";
    public static final String PASSWORD_FIELD = "password";
    public static final String EMAIL_FIELD = "email@naver.com";

    public static TokenResponse 로그인_되어_있음(String username, String email, String password) {
        ExtractableResponse<Response> response = 로그인_요청(username, email, password);
        return response.as(TokenResponse.class);
    }

    private static ExtractableResponse<Response> 로그인_요청(String username, String email, String password) {
        return null;
    }
}
