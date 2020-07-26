package com.ayudantia.chat.Servicios;

import com.ayudantia.chat.Modelos.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User findByUsername(String username);

    List<User> verTodos();
}
