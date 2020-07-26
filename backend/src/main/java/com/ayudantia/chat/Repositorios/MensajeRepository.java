package com.ayudantia.chat.Repositorios;

import com.ayudantia.chat.Modelos.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface MensajeRepository extends JpaRepository<Mensaje, Long>{

    Mensaje findById(long id);

    List<Mensaje> findByAmigo1AndAmigo2OrAmigo2AndAmigo1OrderByIdDesc(long amigo1, long amigo2,long amigo21, long amigo12);
}
