package com.ayudantia.chat.Servicios;

import com.ayudantia.chat.Modelos.Mensaje;

import com.ayudantia.chat.Repositorios.MensajeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class MensajeService {
    
    @Autowired
    MensajeRepository repositorio;


    public boolean ingresar(Mensaje m){
        try {
            repositorio.save(m);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Mensaje> buscar(long amigo1,long amigo2){
        return repositorio.findByAmigo1AndAmigo2OrAmigo2AndAmigo1OrderByIdDesc(amigo1,amigo2,amigo1,amigo2);
    }

}