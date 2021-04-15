package com.wani.workreport.auth.application.provider;

import com.wani.workreport.auth.application.UserDetails;
import com.wani.workreport.auth.application.UserDetailsService;
import com.wani.workreport.auth.domain.Authentication;
import com.wani.workreport.auth.domain.AuthenticationToken;
import com.wani.workreport.auth.excpetion.AuthenticationException;

public class AuthenticationProvider implements AuthenticationManager {

    private final UserDetailsService userDetailsService;

    public AuthenticationProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


    @Override
    public Authentication authenticate(AuthenticationToken authenticationToken) {
        String principal = authenticationToken.getPrincipal();
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal);
        checkAuthentication(userDetails, authenticationToken);
        return new Authentication(userDetails);
    }

    private void checkAuthentication(UserDetails userDetails, AuthenticationToken token) {
        if (userDetails == null) {
            throw new AuthenticationException();
        }

        if (!userDetails.checkCredentials(token.getCredentials())) {
            throw new AuthenticationException();
        }
    }
}
