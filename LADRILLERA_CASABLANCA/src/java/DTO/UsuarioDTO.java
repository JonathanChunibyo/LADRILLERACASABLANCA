/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import controlador.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author anyusername
 */
public class UsuarioDTO {

    public static boolean crearUsuario(String nombre, String contrasenia, String cargo, String tipo, String email) throws SQLException {
        Connection con = conexion.startConnection();
        String query = "INSERT INTO usuario (nombre, contrasenia, cargo, tipo, email) VALUES (?,?,?,?,?);";
        PreparedStatement mensajero = con.prepareStatement(query);
        mensajero.setString(1, nombre);
        mensajero.setString(2, contrasenia);
        mensajero.setString(3, cargo);
        mensajero.setString(4, tipo);
        mensajero.setString(5, email);
        //En teoría esto retorna la cantidad de filas afectadas
        return mensajero.executeUpdate() > 0;
    }
    
     public static boolean eliminarUsuarioPorNombre(String nombre, String contrasenia, String email) throws SQLException {
        Connection con = conexion.startConnection();
        String query = "DELETE FROM usuario WHERE nombre=? AND contrasenia=? AND email=?;";
        PreparedStatement mensajero = con.prepareStatement(query);
        mensajero.setString(1, nombre);
        mensajero.setString(2, contrasenia);
        mensajero.setString(3, email);
        //En teoría esto retorna la cantidad de filas afectadas
        return mensajero.executeUpdate() > 0;
    }

    public static void main(String[] args) throws SQLException {
        
        //System.out.println(UsuarioDTO.crearUsuario("José Tipazo", "98765432", "gerente", "produccion", "uncorreo@ufps.edu.co"));
        System.out.println(UsuarioDTO.eliminarUsuarioPorNombre("Jonathan Adonay Rubio Jimenez", "12345678", "jonathanadonayrj@ufps.edu.co"));
        
    }
}
