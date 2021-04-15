package com.wani.workreport.report.member.documentation;

import com.wani.workreport.Documentation;
import com.wani.workreport.auth.dto.TokenResponse;
import com.wani.workreport.member.dto.MemberResponse;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.restdocs.RestDocumentationContextProvider;

public class MemberDocumentation extends Documentation {

    private MemberResponse 멤버;


    public static final String NAME = "작업자";
    public static final String EMAIL = "email@naver.com";
    public static final String PASSWORD = "password";

    private TokenResponse tokenResponse;

    @BeforeEach
    public void setUp(RestDocumentationContextProvider restDocumentation){
        super.setUp(restDocumentation);
    }

}
