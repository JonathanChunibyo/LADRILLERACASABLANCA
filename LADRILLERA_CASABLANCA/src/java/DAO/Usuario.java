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
public class Usuario {
    String nombre; 
    String contra; 
    String cargo;
    String tipo; 
    String email;

    public Usuario(String nombre, String contra, String cargo, String tipo, String email) {
        this.nombre = nombre;
        this.contra = contra;
        this.cargo = cargo;
        this.tipo = tipo;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    // Método de prueba, puede ser descartado después
    @Override
    public String toString(){
    
        return "Nombre: "+this.nombre+"\nCargo: "+this.cargo+"\nTipo: "+this.tipo+"\nEmail: "+this.tipo;
    }
}
