/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DAO.Usuario;
import controlador.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Random;

/**
 *
 * @author anyusername
 */
public class UsuarioDTO {

    public static boolean crearUsuario(String nombre, String contrasenia, String cargo, String tipo, String email) throws SQLException {
        Connection con = conexion.startConnection();
        // Esta webonada de los '?' se llaman queries parametrizadas. Es una medida de seguridad para
        // evitar injecciones SQL. Lean al respecto.
        String query = "INSERT INTO usuario (nombre, contrasenia, cargo, tipo, email) VALUES (?,?,?,?,?);";
        PreparedStatement mensajero = con.prepareStatement(query);
        mensajero.setString(1, nombre);
        mensajero.setString(2, contrasenia);
        mensajero.setString(3, cargo);
        mensajero.setString(4, tipo);
        mensajero.setString(5, email);
        //En teoría esto retorna la cantidad de filas afectadas (obviamente 0 si no hay ninguna).
        return mensajero.executeUpdate() > 0;
    }

    public static boolean eliminarUsuarioPorNombre(String nombre, String contrasenia, String email) throws SQLException {
        Connection con = conexion.startConnection();
        String query = "DELETE FROM usuario WHERE nombre=? AND contrasenia=? AND email=?;";
        PreparedStatement mensajero = con.prepareStatement(query);
        mensajero.setString(1, nombre);
        mensajero.setString(2, contrasenia);
        mensajero.setString(3, email);
        return mensajero.executeUpdate() > 0;
    }

    // Se asume que los datos a modificar del usuario vienen como un arreglo de tamaño fijo, en
    // el mismo orden en que fue declarada su estructura en la BBDD. El cual es:
    // nombre, cargo, tipo, email, contrasenia
    public static boolean editarUnUsuario(String nombre, String contrasenia, String email, String[] datosNuevos) throws SQLException {
        Connection con = conexion.startConnection();
        String query = "UPDATE usuario SET  nombre=?, cargo=?, tipo=?, email=?, contrasenia=? WHERE nombre=? AND contrasenia=? AND email=?;";
        PreparedStatement mensajero = con.prepareStatement(query);
        mensajero.setString(1, datosNuevos[0]);
        mensajero.setString(2, datosNuevos[1]);
        mensajero.setString(3, datosNuevos[2]);
        mensajero.setString(4, datosNuevos[3]);
        mensajero.setString(5, datosNuevos[4]);
        mensajero.setString(6, nombre);
        mensajero.setString(7, contrasenia);
        mensajero.setString(8, email);
        //En teoría esto retorna la cantidad de filas afectadas
        return mensajero.executeUpdate() > 0;
    }

    public static Usuario informacionDeUnUsuario(String email, String contrasenia) throws SQLException {
        Usuario recuperado = null;
        Connection con = conexion.startConnection();
        String query = "SELECT * FROM usuario WHERE email=? AND contrasenia=?;";
        PreparedStatement mensajero = con.prepareStatement(query);
        mensajero.setString(1, email);
        mensajero.setString(2, contrasenia);
        ResultSet resultados = mensajero.executeQuery();
        // Se para en el primer objeto que haya devuelto este ResultSet y retorna true, si es que hay uno.
        // Si no, retorna false.
        if (resultados.next()) {
            recuperado = new Usuario(resultados.getString("nombre"), resultados.getString("contrasenia"), resultados.getString("cargo"), resultados.getString("tipo"), resultados.getString("email"));
        }
        return recuperado;
    }

    public static void agregarDatos() throws SQLException {

        int anio = 2020;
        int mes = 11;

        double dato = 0;
        int dia = 1;
        int hora = 7;
        int min = 0;
        int linea = 1;

        Random r = new Random();
        Connection con = conexion.startConnection();

        while (dia >= 1) {
            while (linea <= 4) {
                while (hora <= 7) {
                    while (min <= 50) {
                        dato = 10.0 + (99.0 - 10.0) * r.nextDouble();
                        dato = Math.round(dato * 100) / 100d;
                        String query = "INSERT INTO consumo (dato, anio, mes, dia, hora, min, linea) VALUES (?,?,?,?,?,?,?);";
                        PreparedStatement mensajero = con.prepareStatement(query);
                        mensajero.setDouble(1, dato);
                        mensajero.setInt(2, anio);
                        mensajero.setInt(3, mes);
                        mensajero.setInt(4, dia);
                        mensajero.setInt(5, hora);
                        mensajero.setInt(6, min);
                        mensajero.setInt(7, linea);
                        mensajero.executeUpdate();
                        min += 10;
                    }
                    min = 0;
                    hora++;
                }
                hora = 7;
                linea++;
            }
            linea = 1;
            dia--;
        }

    }

    // Esto de aquí para abajo existe explícitamente con propósitos de prueba, pueden deshacerse de ella si ya se sienten
    // Seguros de que la clase está funcionando bien.
    public static void main(String[] args) throws SQLException {

        //System.out.println(UsuarioDTO.crearUsuario("José Tipazo", "98765432", "gerente", "produccion", "uncorreo@ufps.edu.co"));
        //agregarDatos();
        //System.out.println(UsuarioDTO.eliminarUsuarioPorNombre("Jonathan Adonay Rubio Jimenez", "12345678", "jonathanadonayrj@ufps.edu.co"));
    }
}
