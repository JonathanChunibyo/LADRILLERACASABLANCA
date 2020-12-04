/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.*;

/**
 *
 * @author Jose
 */
public class conexion {
      public static Connection startConnection(){

        String url = "jdbc:mysql://3.92.88.197:3306/Ladrillera";
        String user = "admin";
        String password = "B@53S_202O_OF1W=4YI";
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection cn = DriverManager.getConnection(url,user, password);
            return cn;

        } catch(ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e){

            System.out.println("System retrieved an error, connection aborted\n"+e.getLocalizedMessage());
        }

        return null;
    }
}
