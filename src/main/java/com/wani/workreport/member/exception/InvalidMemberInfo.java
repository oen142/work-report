package com.wani.workreport.member.exception;

public class InvalidMemberInfo extends RuntimeException {

    public InvalidMemberInfo() {
    }

    public InvalidMemberInfo(String message) {
        super(message);
    }
}
