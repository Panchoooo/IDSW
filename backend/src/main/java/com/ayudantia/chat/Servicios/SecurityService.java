package com.ayudantia.chat.Servicios;

import org.springframework.http.ResponseEntity;

public interface SecurityService {
    ResponseEntity<?> autoLogin(String username, String password);
}
