package com.wani.workreport.auth.application;

public interface UserDetails {

    Object getPrincipal();

    Object getCredentials();

    boolean checkCredentials(Object credentials);
}
