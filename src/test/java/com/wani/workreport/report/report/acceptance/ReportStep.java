package com.wani.workreport.report.report.acceptance;

import com.wani.workreport.auth.dto.TokenResponse;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class ReportStep {

    public static ExtractableResponse<Response> 리포트_생성_요청(TokenResponse tokenResponse, String title) {
        Map<String, String> params = new HashMap<>();
        params.put("title", title);

        return null;
    }
}
