package com.example.mangav2.controller;

import com.example.mangav2.config.IAuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class SecurityController {
    @Autowired
    private IAuthenticationFacade authenticationFacade;

    public String getCurrentUserName() {
        Authentication authentication = authenticationFacade.getAuthentication();
        return authentication.getName();

    }

}
