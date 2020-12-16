/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DTO.produccionDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jose
 */
public class graficaProduccion {

    String a = "";

    public String graficaSemana() throws SQLException {
        ResultSet rUno = produccionDTO.datosSemana("1");
        ResultSet rDos = produccionDTO.datosSemana("2");
        ResultSet rTres = produccionDTO.datosSemana("3");
        ResultSet rCuatro = produccionDTO.datosSemana("4");

        a = "google.charts.load('current', {'packages':['bar']});\n"
                + "google.charts.setOnLoadCallback(drawChart);\n"
                + "function drawChart() {\n"
                + "var data = google.visualization.arrayToDataTable([\n"
                + "['Fecha', 'Linea 1', 'Linea 2', 'Linea 3', 'Linea 4'],\n";
        
        //rUno.next();
        //+ "['2014', 1000, 400, 200, 500],\n"
        //a += "['2014'," + rUno.getString("metros") +", 400, 200, 500],\n";
        while (rUno.next() && rDos.next() && rTres.next() && rCuatro.next()) {
            a += "['" + rUno.getString("dia") + "/" + rUno.getString("mes") + "/" + rUno.getString("anio") + "'," + rUno.getString("metros") + "," + rDos.getString("metros") + "," + rTres.getString("metros") + "," + rCuatro.getString("metros") + "],\n";
        }
        a += "]);\n"
                + "var options = {\n"
                + "chart: {\n"
                + "title: 'Produccion de los ultimos 7 dias registrados',\n"
                + "}\n"
                + "};\n"
                + "var chart = new google.charts.Bar(document.getElementById('columnchart_material'));\n"
                + "chart.draw(data, google.charts.Bar.convertOptions(options));\n"
                + "}";

        return a;
    }

    public String graficaTablas() throws SQLException {
        ResultSet r = produccionDTO.datosTotal();
        a = "";
        while (r.next()) {
            a += "<tr><td>Linea" + r.getString("linea") + "</td><td>" + r.getString("metros") + "</td><td>" + r.getString("material") + "</td><td>" + r.getString("dia") + "/" + r.getString("mes") + "/" + r.getString("anio") + "</td><td>" + r.getString("observacion") + "</td></tr>";
        }
        return a;
    }
}
