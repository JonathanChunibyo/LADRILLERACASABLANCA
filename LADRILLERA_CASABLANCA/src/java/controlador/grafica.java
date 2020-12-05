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
    String x = "";

    public String graficar() throws SQLException {
        Connection cn = conexion.startConnection();
        Statement st = cn.createStatement();
        String query = "SELECT * FROM consumo;";
        ResultSet rs = st.executeQuery(query);

        a = "google.charts.load('current', {'packages': ['line']});\n"
                + "google.charts.setOnLoadCallback(drawChart);\n"
                + "function drawChart() {\n"
                + "var data = new google.visualization.DataTable();\n"
                + "data.addColumn('string', 'Hora');\n"
                + "data.addColumn('number', 'Consumo');\n"
                + "data.addRows([";

        while (rs.next()) {
            x = (rs.getInt("min") <= 9) ? "0" + rs.getString("min") : rs.getString("min");
            a += "['" + rs.getString("hora") + ":" + x + "'," + rs.getString("dato") + "],";
        }
        a += "]);\n"
                + "var options = {\n"
                + "width: 800,\n"
                + "height: 250\n"
                + "};\n"
                + "var chart = new google.charts.Line(document.getElementById('curve_chart'));\n"
                + "chart.draw(data, google.charts.Line.convertOptions(options));\n"
                + "}";

        return a;
    }
}
