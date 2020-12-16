/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DAO.ConsumoDia;
import controlador.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Jose
 */
public class ConsumoDTO {

    public static ArrayList datosLineaDia(String linea, String dia, String mes) throws SQLException {
        Connection con = conexion.startConnection();
        String query = "SELECT * FROM consumo WHERE linea=? AND dia=? AND mes=?;";
        PreparedStatement mensajero = con.prepareStatement(query);
        mensajero.setString(1, linea);
        mensajero.setString(2, dia);
        mensajero.setString(3, mes);
        ResultSet r = mensajero.executeQuery();

        ArrayList<ConsumoDia> c = new ArrayList();
        String x = "";

        while (r.next()) {
            x = (r.getInt("min") <= 9) ? "0" + r.getString("min") : r.getString("min");
            c.add(new ConsumoDia(r.getString("hora") + ":" + x, r.getString("dato")));
        }

        return c;
    }

    public static ResultSet datosLineaSemana(String linea) throws SQLException {
        Connection con = conexion.startConnection();
        String query = "SELECT linea, mes, dia, MAX(dato) FROM consumo WHERE linea=? GROUP BY anio, mes, dia ORDER BY anio DESC, mes DESC, dia DESC limit 7;";
        PreparedStatement mensajero = con.prepareStatement(query);
        mensajero.setString(1, linea);
        ResultSet r = mensajero.executeQuery();

        return r;
    }

    public static ResultSet datosLineaMes(String linea) throws SQLException {
        Connection con = conexion.startConnection();
        String query = "SELECT linea, mes, dia, MAX(dato) FROM consumo WHERE linea=? GROUP BY anio, mes, dia ORDER BY anio DESC, mes DESC, dia DESC limit 30;";
        PreparedStatement mensajero = con.prepareStatement(query);
        mensajero.setString(1, linea);
        ResultSet r = mensajero.executeQuery();

        return r;
    }

    public static ResultSet datosTotal() throws SQLException {
        Connection con = conexion.startConnection();
        String query = "SELECT * FROM consumo ORDER BY anio DESC, mes DESC, dia DESC;";
        PreparedStatement mensajero = con.prepareStatement(query);
        ResultSet r = mensajero.executeQuery();

        return r;
    }

    public static void AgregarDatos(Connection r, String dato, String anio, String mes, String dia, String hora, String min, String linea) throws SQLException {
        Connection con = r;
        String query = "INSERT INTO consumo (dato, anio, mes, dia, hora, min, linea) VALUES (?,?,?,?,?,?,?);";
        PreparedStatement mensajero = con.prepareStatement(query);
        mensajero.setString(1, dato);
        mensajero.setString(2, anio);
        mensajero.setString(3, mes);
        mensajero.setString(4, dia);
        mensajero.setString(5, hora);
        mensajero.setString(6, min);
        mensajero.setString(7, linea);
        mensajero.executeUpdate();
    }
    
    public static ResultSet datoAlerta() throws SQLException {
        Connection con = conexion.startConnection();
        Calendar c = new GregorianCalendar();
        String query = "SELECT * FROM consumo WHERE anio=? AND mes=? AND dia=? AND dato>300;";
        PreparedStatement mensajero = con.prepareStatement(query);
        mensajero.setString(1, String.valueOf(c.get(Calendar.YEAR)));
        mensajero.setString(2, String.valueOf(c.get(Calendar.MONTH) + 1));
        mensajero.setString(3, String.valueOf(c.get(Calendar.DATE)));
        ResultSet r = mensajero.executeQuery();

        return r;
    }

    public static void main(String[] args) throws SQLException {
        
    }
}
