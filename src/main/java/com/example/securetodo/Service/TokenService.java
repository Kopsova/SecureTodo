package com.example.securetodo.Service;

import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    String myToken = "GFA";

    public boolean exists(String token) {
        return token.equals(myToken);
    }

    public String getUser(String token) {
        if (token.equals(myToken))
            return "Admin";
        else
            throw new AuthorizationServiceException("No username for this token");
    }

    public String getPassowrd(String token) {
        return "heslo";
    }
}