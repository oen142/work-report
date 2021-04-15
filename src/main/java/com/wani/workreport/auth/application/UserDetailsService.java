package com.wani.workreport.auth.application;

public interface UserDetailsService {
    UserDetails loadUserByUsername(String principal);

}
