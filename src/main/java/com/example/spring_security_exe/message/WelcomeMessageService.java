package com.example.spring_security_exe.message;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class WelcomeMessageService {
    private static final String LANG_EN = "en";
    private static final String LANG_PL = "pl";
    private static final String LANG_ES = "es";

    /*
    Tutaj wykorzystujemy metody statyczne SecurityContexHolder dzięki czemu nie ma potrzeby wstrzykiwania obiektów za pomocą Springa jak
    to robiliśmy w kontrolerze do metdy get()
     */
    public String getWelcomeMessage(String lang) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        String welcomeMessage = switch (lang) {
            case LANG_ES -> "Hola ";
            case LANG_PL -> "Cześć ";
            default ->  "Hello ";
        };
        return welcomeMessage + username;
    }
}
