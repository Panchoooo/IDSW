package com.ayudantia.chat.Servicios;

import com.ayudantia.chat.Modelos.User;
import com.ayudantia.chat.Repositorios.RoleRepository;
import com.ayudantia.chat.Repositorios.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword())); // Se guarda password encriptada
        user.setRoles(new HashSet<>(roleRepository.findAll()));  // Se ingresan los roles respectivos.
        userRepository.save(user); // repositorio es encargado de guardar al usuario.
    }

    @Override
    public User findByUsername(String username) { // Buscar por nombre
        return userRepository.findByUsername(username); 
    }

    @Override
    public List<User> verTodos() { // Buscar por nombre
        return userRepository.findAll(); 
    }

}
