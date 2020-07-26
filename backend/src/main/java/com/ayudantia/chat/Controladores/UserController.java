package com.ayudantia.chat.Controladores;

import com.ayudantia.chat.Controladores.util.*;
import com.ayudantia.chat.Jwt.JwtUtil;
import com.ayudantia.chat.Modelos.User;
import com.ayudantia.chat.Modelos.Mensaje;
import com.ayudantia.chat.Servicios.SecurityService;
import com.ayudantia.chat.Servicios.UserService;
import com.ayudantia.chat.Servicios.MensajeService;
import com.ayudantia.chat.Servicios.UserServiceImpl;
import com.ayudantia.chat.Validador.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private MensajeService mensajeService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private JwtUtil jwtu;

    

    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody AuthenticationRequest request, BindingResult bindingResult) {
        User u = new User(request.getUsername(),request.getPassword(),request.getPasswordConfirm());
        userValidator.validate(u, bindingResult);
        if (bindingResult.hasErrors()) {
            return null;
        } 
        userService.save(u);       
        
        return securityService.autoLogin(u.getUsername(), u.getPasswordConfirm());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest request) {
        return securityService.autoLogin(request.getUsername(), request.getPassword());
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }

    @GetMapping("/verTodos")
    public List<User> verTodos(@RequestHeader("Authorization") String jwt){
        // extraigo el usuario
        jwt = jwt.substring(7);
        String n = jwtu.extractUsername(jwt);
        return userServiceImpl.verTodos();
    }

    @PostMapping("/verMensajes")
    public List<Mensaje> verTodosM(@RequestBody MensajeRequest request,@RequestHeader("Authorization") String jwt){
        // extraigo el usuario
        jwt = jwt.substring(7);
        String n = jwtu.extractUsername(jwt);
        User u = userService.findByUsername(n);
        return mensajeService.buscar(u.getId(),request.getAmigo2());
    }

    @PostMapping("/ingMensajes")
    public boolean ingMensaje(@RequestBody MensajeRequest request,@RequestHeader("Authorization") String jwt){
        // extraigo el usuario
        jwt = jwt.substring(7);
        String n = jwtu.extractUsername(jwt);
        User u = userService.findByUsername(n);
        Mensaje m = new Mensaje(u.getId(),request.getAmigo2(),request.getTexto());
        return mensajeService.ingresar(m);
    }

}


