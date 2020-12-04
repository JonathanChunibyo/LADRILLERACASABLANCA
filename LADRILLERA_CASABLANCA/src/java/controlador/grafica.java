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
public class grafica {

    String a = "";

    public String graficar() throws SQLException {
        Connection cn = conexion.startConnection();
        Statement st = cn.createStatement();
        String query = "SELECT * FROM consumo;";
        ResultSet rs = st.executeQuery(query);

        a = "google.charts.load('current', {'packages':['corechart']});\n"
                + "google.charts.setOnLoadCallback(drawChart);\n"
                + "function drawChart() {\n"
                + "var data = google.visualization.arrayToDataTable(["
                + "['Hora', 'Datos'],";

        while (rs.next()) {
            a += "['" + rs.getString("hora") + ":" + rs.getString("min") + "'," + rs.getString("dato") + "],";
        }

        a += "]);\n"
                + "\n"
                + "var options = {\n"
                + "title: 'Consumo',\n"
                + "curveType: 'function',\n"
                + "legend: { position: 'bottom' }\n"
                + "};\n"
                + "var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));\n"
                + "chart.draw(data, options);\n"
                + "}";

        return a;
    }
    public static void main(String[] args) throws SQLException {
        grafica a = new grafica();
        System.out.println(a.graficar());
        
    }
}
