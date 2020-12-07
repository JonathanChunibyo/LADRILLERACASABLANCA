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

    public String graficaDiaUno(String linea) throws SQLException {
        ArrayList<ConsumoDia> conDia = ConsumoDTO.datosLineaDia(linea, "7");
        a = "google.charts.load('current', {'packages':['corechart']});\n"
                + "google.charts.setOnLoadCallback(drawChart);\n"
                + "function drawChart() {\n"
                + "var data = google.visualization.arrayToDataTable(["
                + "['Hora', 'Datos'],";
        for (ConsumoDia consumoDia : conDia) {
            a += "['" + consumoDia.getHora() + "'," + consumoDia.getDato() + "],";
        }
        a += "]);\n"
                + "var options = {\n"
                + "hAxis: {title: 'Datos',  titleTextStyle: {color: '#333'}},\n"
                + "vAxis: {minValue: 0}\n"
                + "};\n"
                + "var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));\n"
                + "chart.draw(data, options);\n"
                + "}";

        return a;
    }

    public String graficaSemanaUno(String linea) throws SQLException {
        ResultSet r = ConsumoDTO.datosLineaSemana(linea);

        a = "google.charts.load('current', {'packages':['corechart']});\n"
                + "google.charts.setOnLoadCallback(drawChart2);\n"
                + "function drawChart2() {\n"
                + "var data2 = google.visualization.arrayToDataTable(["
                + "['Dia', 'Datos'],";
        int x = 1;

        while (r.next()) {
            if (x <= 6) {
                a += "['" + r.getString("dia") + "'," + r.getString("consumo") + "],";
                x++;
            }
        }
        a += "]);\n"
                + "var options2 = {\n"
                + "hAxis: {title: 'Datos',  titleTextStyle: {color: '#333'}},\n"
                + "vAxis: {minValue: 0}\n"
                + "};\n"
                + "var chart2 = new google.visualization.AreaChart(document.getElementById('chart_div2'));\n"
                + "chart2.draw(data2, options2);\n"
                + "}";

        return a;
    }
}
