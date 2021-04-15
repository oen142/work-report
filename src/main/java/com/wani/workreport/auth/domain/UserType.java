package com.wani.workreport.auth.domain;


import com.wani.workreport.auth.excpetion.NotFoundLoginTypeException;
import java.util.Arrays;

public enum UserType {
    ANONYMOUS,
    USER;

    UserType() {
    }

    public static UserType get(String str) {
        return Arrays.stream(UserType.values())
                .filter(type -> type.name().equals(str))
                .findFirst()
                .orElseThrow(NotFoundLoginTypeException::new);
    }
}
