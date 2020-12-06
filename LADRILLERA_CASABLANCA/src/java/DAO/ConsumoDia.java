/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Jose
 */
public class ConsumoDia {

    String hora;
    String dato;

    public ConsumoDia(String hora, String dato) {
        this.hora = hora;
        this.dato = dato;
    }

    public ConsumoDia() {
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }
}
