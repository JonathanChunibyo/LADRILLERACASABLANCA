/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DAO.ConsumoDia;
import DTO.ConsumoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jose
 */
public class graficaLinea1 {
    String a = "";
    
    public String graficaDiaUno() throws SQLException{
        ArrayList<ConsumoDia> conDia = ConsumoDTO.datosLineaDia("1", "7");
        a = "google.charts.load('current', {'packages': ['line']});\n"
                + "google.charts.setOnLoadCallback(drawChart);\n"
                + "function drawChart() {\n"
                + "var data = new google.visualization.DataTable();\n"
                + "data.addColumn('string', 'Hora');\n"
                + "data.addColumn('number', 'Consumo');\n"
                + "data.addRows([";

        for (ConsumoDia consumoDia : conDia) {
            a += "['" + consumoDia.getHora() + "'," + consumoDia.getDato() + "],";
        }
        a += "]);\n"
                + "var options = {\n"
                + "width: 1200,\n"
                + "height: 300\n"
                + "};\n"
                + "var chart = new google.charts.Line(document.getElementById('curve_chart'));\n"
                + "chart.draw(data, google.charts.Line.convertOptions(options));\n"
                + "}";

        return a;
    }
    
    public String graficaSemanaUno() throws SQLException{
        ResultSet r = ConsumoDTO.datosLineaSemana("1");
        
        a = "google.charts.load('current', {'packages': ['line']});\n"
                + "google.charts.setOnLoadCallback(drawChart2);\n"
                + "function drawChart2() {\n"
                + "var data2 = new google.visualization.DataTable();\n"
                + "data2.addColumn('string', 'Dia');\n"
                + "data2.addColumn('number', 'Consumo');\n"
                + "data2.addRows([";

        while(r.next()) {
            a += "['" + r.getString("dia")+ "'," + r.getString("Promedio") + "],";
        }
        a += "]);\n"
                + "var options2 = {\n"
                + "width: 1200,\n"
                + "height: 300\n"
                + "};\n"
                + "var chart2 = new google.charts.Line(document.getElementById('semanaLinea1'));\n"
                + "chart2.draw(data2, google.charts.Line.convertOptions(options2));\n"
                + "}";
        
        return a;
    }
}
