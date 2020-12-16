/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import controlador.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Jose
 */
public class produccionDTO {
    
    public static String datosDia(String linea) throws SQLException{
        Connection con = conexion.startConnection();
        Calendar c = new GregorianCalendar();
        String query = "SELECT * FROM produccion WHERE anio=? AND mes=? AND dia=? AND linea=?;";
        PreparedStatement mensajero = con.prepareStatement(query);
        mensajero.setString(1, String.valueOf(c.get(Calendar.YEAR)));
        mensajero.setString(2, String.valueOf(c.get(Calendar.MONTH) + 1));
        mensajero.setString(3, String.valueOf(c.get(Calendar.DATE)));
        mensajero.setString(4, linea);
        ResultSet r = mensajero.executeQuery();
        r.next();
        return r.getString("metros");
    }
    
    public static ResultSet datosSemana(String linea) throws SQLException {
        Connection con = conexion.startConnection();
        String query = "SELECT linea, anio, mes, dia, metros, material FROM produccion WHERE linea=? GROUP BY anio, mes, dia ORDER BY anio DESC, mes DESC, dia DESC limit 7;";
        PreparedStatement mensajero = con.prepareStatement(query);
        mensajero.setString(1, linea);
        ResultSet r = mensajero.executeQuery();

        return r;
    }
    
    public static ResultSet datosTotal() throws SQLException {
        Connection con = conexion.startConnection();
        String query = "SELECT * FROM produccion ORDER BY anio DESC, mes DESC, dia DESC;";
        PreparedStatement mensajero = con.prepareStatement(query);
        ResultSet r = mensajero.executeQuery();

        return r;
    }

    public static void AgregarDatos(Connection r, String anio, String mes, String dia, String metros, String material, String linea, String observacion) throws SQLException {
        Connection con = r;
        String query = "INSERT INTO produccion (anio, mes, dia, metros, material, linea, observacion) VALUES (?,?,?,?,?,?,?);";
        PreparedStatement mensajero = con.prepareStatement(query);
        mensajero.setString(1, anio);
        mensajero.setString(2, mes);
        mensajero.setString(3, dia);
        mensajero.setString(4, metros);
        mensajero.setString(5, material);
        mensajero.setString(6, linea);
        mensajero.setString(7, observacion);
        mensajero.executeUpdate();
    }
    
    public static void modificarMetros(String linea, String anio, String mes, String dia, String modificar) throws SQLException{
        Connection con = conexion.startConnection();
        String query = "UPDATE produccion SET metros=? WHERE anio=? AND mes=? AND dia=? AND linea=?;";
        PreparedStatement mensajero = con.prepareStatement(query);
        mensajero.setString(1, modificar);
        mensajero.setString(2, anio);
        mensajero.setString(3, mes);
        mensajero.setString(4, dia);
        mensajero.setString(5, linea);
    }
    
    public static boolean buscarDato() throws SQLException{
        boolean rt = false;
        Connection con = conexion.startConnection();
        Calendar c = new GregorianCalendar();
        String query = "SELECT * FROM produccion WHERE anio=? AND mes=? AND dia=?;";
        PreparedStatement mensajero = con.prepareStatement(query);
        mensajero.setString(1, String.valueOf(c.get(Calendar.YEAR)));
        mensajero.setString(2, String.valueOf(c.get(Calendar.MONTH) + 1));
        mensajero.setString(3, String.valueOf(c.get(Calendar.DATE)));
        ResultSet r = mensajero.executeQuery();
        
        while (r.next()) {            
            if (Double.parseDouble(r.getString("metros")) <= 400) {
                rt = true;
            }
        }
        
        return rt;
    }
    
    public static ResultSet buscarAlerta() throws SQLException{
        Connection con = conexion.startConnection();
        Calendar c = new GregorianCalendar();
        String query = "SELECT * FROM produccion WHERE anio=? AND mes=? AND dia=? AND metros<400;";
        PreparedStatement mensajero = con.prepareStatement(query);
        mensajero.setString(1, String.valueOf(c.get(Calendar.YEAR)));
        mensajero.setString(2, String.valueOf(c.get(Calendar.MONTH) + 1));
        mensajero.setString(3, String.valueOf(c.get(Calendar.DATE)));
        ResultSet r = mensajero.executeQuery();
        
        return r;
    }

    public static void main(String[] args) throws SQLException {
        /*
        ResultSet r = datosSemana("4");
        while (r.next()) {            
            System.out.println(r.getString("dia"));
        }
        */
        //Connection con = conexion.startConnection();
        //AgregarDatos(con, "2020", "11", "14", "700", "1", "2", "Todo Bien");
        
        //System.out.println(buscarDato());
        
        //modificarMetros("1", "2020", "12", "15", "390.20");
        //System.out.println(datosDia("1"));
        
        
    }
}
