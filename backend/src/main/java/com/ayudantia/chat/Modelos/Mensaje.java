package com.ayudantia.chat.Modelos;

import javax.persistence.*;


// Tabla para roles
@Entity
@Table(name = "mensaje")
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long amigo1;

    private Long amigo2;

    private String texto;



    public Mensaje() {
    }

    public Mensaje(Long id, Long amigo1, Long amigo2, String texto) {
        this.id = id;
        this.amigo1 = amigo1;
        this.amigo2 = amigo2;
        this.texto = texto;
    }

    public Mensaje( Long amigo1, Long amigo2, String texto) {
        this.amigo1 = amigo1;
        this.amigo2 = amigo2;
        this.texto = texto;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAmigo1() {
        return this.amigo1;
    }

    public void setAmigo1(Long amigo1) {
        this.amigo1 = amigo1;
    }

    public Long getAmigo2() {
        return this.amigo2;
    }

    public void setAmigo2(Long amigo2) {
        this.amigo2 = amigo2;
    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }


}