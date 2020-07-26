package com.ayudantia.chat.Controladores.util;

public class MensajeRequest{

    private Long amigo1;
    private Long amigo2;
    private String texto;

    public MensajeRequest() {
    }

    public MensajeRequest(Long amigo1, Long amigo2, String texto) {
        this.amigo1 = amigo1;
        this.amigo2 = amigo2;
        this.texto = texto;
    }

    public MensajeRequest(Long amigo2) {
        this.amigo2 = amigo2;
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
