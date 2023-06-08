package com.example.reto3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class UserController {
    @GetMapping("/user")
    public Map<String, Object> user (@AuthenticationPrincipal OAuth2User principal){
        System.out.println("Datos del usuario\n" + principal.getAttributes());
        return null; //Collections.singletonMap("name", principal.getAttributes("name"));
    }
}
