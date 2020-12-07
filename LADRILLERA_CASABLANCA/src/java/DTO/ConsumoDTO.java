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

/**
 *
 * @author Jose
 */
public class ConsumoDTO {
    
    public static ArrayList datosLineaDia(String linea, String dia) throws SQLException {
        Connection con = conexion.startConnection();
        String query = "SELECT * FROM consumo WHERE linea=? AND dia=?;";
        PreparedStatement mensajero = con.prepareStatement(query);
        mensajero.setString(1, linea);
        mensajero.setString(2, dia);
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
        String query = "SELECT dia, sum(dato) as consumo FROM consumo WHERE linea=? GROUP BY dia;";
        PreparedStatement mensajero = con.prepareStatement(query);
        mensajero.setString(1, linea);
        ResultSet r = mensajero.executeQuery();
        
        return r;
    }
}
