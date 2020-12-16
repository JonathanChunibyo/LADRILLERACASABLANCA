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
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Jose
 */
public class graficaConsumo {

    String a = "";

    public String graficaDia(String linea) throws SQLException {
        Calendar c = new GregorianCalendar();
        ArrayList<ConsumoDia> conDia = ConsumoDTO.datosLineaDia(linea, String.valueOf(c.get(Calendar.DATE)), String.valueOf(c.get(Calendar.MONTH) + 1));
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

    public String graficaSemana(String linea) throws SQLException {
        ResultSet r = ConsumoDTO.datosLineaSemana(linea);

        a = "google.charts.load('current', {'packages':['corechart']});\n"
                + "google.charts.setOnLoadCallback(drawChart2);\n"
                + "function drawChart2() {\n"
                + "var data2 = google.visualization.arrayToDataTable(["
                + "['Dia', 'Datos'],";
        while (r.next()) {
            a += "['" + r.getString("dia") + "/" + r.getString("mes") + "'," + r.getString("MAX(dato)") + "],";
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

    public String graficaMes(String linea) throws SQLException {
        ResultSet r = ConsumoDTO.datosLineaMes(linea);

        a = "google.charts.load('current', {'packages':['corechart']});\n"
                + "google.charts.setOnLoadCallback(drawChart3);\n"
                + "function drawChart3() {\n"
                + "var data3 = google.visualization.arrayToDataTable(["
                + "['Dia', 'Datos'],";
        while (r.next()) {
            a += "['" + r.getString("dia") + "/" + r.getString("mes") + "'," + r.getString("MAX(dato)") + "],";

        }
        a += "]);\n"
                + "var options3 = {\n"
                + "hAxis: {title: 'Datos',  titleTextStyle: {color: '#333'}},\n"
                + "vAxis: {minValue: 0}\n"
                + "};\n"
                + "var chart3 = new google.visualization.AreaChart(document.getElementById('chart_div3'));\n"
                + "chart3.draw(data3, options3);\n"
                + "}";
        return a;
    }
    
    public String graficaTablas() throws SQLException {
        ResultSet r = ConsumoDTO.datosTotal();
        a = "";
        while (r.next()) {
            a += "<tr><td>Linea" + r.getString("linea") + "</td><td>" + r.getString("dato") + "</td><td>" + r.getString("dia") + "/" + r.getString("mes") + "/" + r.getString("anio") + "</td></tr>";
        }
        return a;
    }
}
