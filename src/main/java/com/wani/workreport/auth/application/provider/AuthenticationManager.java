package com.wani.workreport.auth.application.provider;

import com.wani.workreport.auth.domain.Authentication;
import com.wani.workreport.auth.domain.AuthenticationToken;

public interface AuthenticationManager {
    Authentication authenticate(AuthenticationToken authenticationToken);
}
