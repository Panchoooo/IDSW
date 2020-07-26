package com.ayudantia.chat.Repositorios;

import com.ayudantia.chat.Modelos.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username); 
 
}
