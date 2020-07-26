package com.ayudantia.chat.Servicios;

import com.ayudantia.chat.Controladores.util.AuthenticationResponse;
import com.ayudantia.chat.Jwt.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService{
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Override
    public ResponseEntity<?> autoLogin(String username, String password) { // Metodo para logear.
        UserDetails userDetails = userDetailsService.loadUserByUsername(username); // Carga el usuario con el username.
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities()); // genera el token respectivo a sus datos 
        authenticationManager.authenticate(usernamePasswordAuthenticationToken); // autentifica el token obtenido.
        if (usernamePasswordAuthenticationToken.isAuthenticated()) { // si esta autentificado es un logeo exitoso.
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken); 
            final UserDetails userDetalles = userDetailsService.loadUserByUsername(username);
            final String jwt = jwtTokenUtil.generateToken(userDetalles);
            return ResponseEntity.ok(new AuthenticationResponse(jwt));
        }
        return null;


    }
}
