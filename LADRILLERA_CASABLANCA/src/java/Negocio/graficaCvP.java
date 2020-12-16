/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DTO.ConsumoDTO;
import DTO.produccionDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Jose
 */
public class graficaCvP {

    String a = "";

    public String consumoVproduccion() throws SQLException {
        ResultSet c1 = ConsumoDTO.datosLineaSemana("1");
        ResultSet c2 = ConsumoDTO.datosLineaSemana("2");
        ResultSet c3 = ConsumoDTO.datosLineaSemana("3");
        ResultSet c4 = ConsumoDTO.datosLineaSemana("4");

        ResultSet p1 = produccionDTO.datosSemana("1");
        ResultSet p2 = produccionDTO.datosSemana("2");
        ResultSet p3 = produccionDTO.datosSemana("3");
        ResultSet p4 = produccionDTO.datosSemana("4");

        a += "google.charts.load('current', {'packages':['corechart']});\n"
                + "google.charts.setOnLoadCallback(drawChart);\n"
                + "function drawChart() {\n"
                + "var data = google.visualization.arrayToDataTable(["
                + "['Fecha', 'Linea 1', 'Linea 2', 'Linea 3', 'Linea 4'],";

        while (c1.next() && c2.next() && c3.next() && c4.next() && p1.next() && p2.next() && p3.next() && p4.next()) {
            a += "['" + p1.getString("dia") + "/" + p1.getString("mes") + "/" + p1.getString("anio") + "', " + Double.parseDouble(p1.getString("metros")) / Double.parseDouble(c1.getString("MAX(dato)")) + ", " + Double.parseDouble(p2.getString("metros")) / Double.parseDouble(c2.getString("MAX(dato)")) + ", " + Double.parseDouble(p3.getString("metros")) / Double.parseDouble(c3.getString("MAX(dato)")) + ", " + Double.parseDouble(p4.getString("metros")) / Double.parseDouble(c4.getString("MAX(dato)")) + "],";
        }

        a += "]);\n"
                + "var options = {\n"
                + "title: 'Consumo Vs Produccion',\n"
                + "hAxis: {title: 'Fecha',  titleTextStyle: {color: '#333'}},\n"
                + "vAxis: {minValue: 0}\n"
                + "};\n"
                + "var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));\n"
                + "chart.draw(data, options);\n"
                + "}";

        return a;
    }
}
