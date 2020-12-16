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
public class graficarAlertas {

    String a = "";

    public String graficaAlerta() throws SQLException {
        a = "<div class=\"d-sm-flex align-items-center justify-content-between mb-4\">\n"
                + "<h1 class=\"h3 mb-0 text-gray-800\">Todo Normal</h1>\n"
                + "</div>\n";

        if (produccionDTO.buscarDato()) {
            Calendar c = new GregorianCalendar();

            a = "<div class=\"d-sm-flex align-items-center justify-content-between mb-4\">\n"
                    + "<h1 class=\"h3 mb-0 text-gray-800\">Alertas del " + c.get(Calendar.DATE) + "/" + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.YEAR) + "</h1>\n"
                    + "</div>\n"
                    + "<div class=\"row\">\n";

            ResultSet r = produccionDTO.buscarAlerta();
            while (r.next()) {
                a += "<div class=\"col-xl-3 col-md-6 mb-4\">\n"
                        + "<div class=\"card border-left-warning shadow h-100 py-2\">\n"
                        + "<div class=\"card-body\">\n"
                        + "<div class=\"row no-gutters align-items-center\">\n"
                        + "<div class=\"col mr-2\">\n"
                        + "<div class=\"text-xs font-weight-bold text-warning text-uppercase mb-1\">Produccion Baja</div>\n"
                        + "<div>";
                a += "<b>Linea:</b> " + r.getString("linea") + "<br><b>Produccion:</b> " + r.getString("metros");
                a += "<form action=\"enviarCorreo\" class=\"user\">\n"
                        + "<div class=\"form-group\">\n"
                        + "<input type=\"hidden\" class=\"form-control form-control-user\" name=\"linea\" value=\"" + r.getString("linea") + "\">\n"
                        + "</div>\n"
                        + "<div class=\"form-group\">\n"
                        + "<input type=\"hidden\" class=\"form-control form-control-user\" name=\"dato\" value=\"" + r.getString("metros") + "\">\n"
                        + "</div>\n"
                        + "<div class=\"form-group\">\n"
                        + "<input type=\"hidden\" class=\"form-control form-control-user\" name=\"tipo\" value=\"Produccion\">\n"
                        + "</div>\n"
                        + "<div class=\"form-group\">\n"
                        + "<input type=\"hidden\" class=\"form-control form-control-user\" name=\"tipoDato\" value=\"Metros\">\n"
                        + "</div>\n"
                        + "<hr>\n"
                        + "<input type=\"submit\" value=\"Notificar\" class=\"btn btn-primary btn-user btn-block\">\n"
                        + "</form>"
                        + "</div>\n"
                        + "</div>\n"
                        + "<div class=\"col-auto\">\n"
                        + "</div>\n"
                        + "</div>\n"
                        + "</div>\n"
                        + "</div>\n"
                        + "</div>\n";
            }

            ResultSet r2 = ConsumoDTO.datoAlerta();
            while (r2.next()) {
                a += "<div class=\"col-xl-3 col-md-6 mb-4\">\n"
                        + "<div class=\"card border-left-success shadow h-100 py-2\">\n"
                        + "<div class=\"card-body\">\n"
                        + "<div class=\"row no-gutters align-items-center\">\n"
                        + "<div class=\"col mr-2\">\n"
                        + "<div class=\"text-xs font-weight-bold text-success text-uppercase mb-1\">Consumo alto</div>\n"
                        + "<div><b>Linea: " + r2.getString("linea") + "<br>Consumo: " + r2.getString("dato") + "</b>"
                        + "<form action=\"enviarCorreo\" class=\"user\">\n"
                        + "<div class=\"form-group\">\n"
                        + "<input type=\"hidden\" class=\"form-control form-control-user\" name=\"linea\" value=\"" + r2.getString("linea") + "\">\n"
                        + "</div>\n"
                        + "<div class=\"form-group\">\n"
                        + "<input type=\"hidden\" class=\"form-control form-control-user\" name=\"dato\" value=\"" + r2.getString("dato") + "\">\n"
                        + "</div>\n"
                        + "<div class=\"form-group\">\n"
                        + "<input type=\"hidden\" class=\"form-control form-control-user\" name=\"tipo\" value=\"Consumo\">\n"
                        + "</div>\n"
                        + "<div class=\"form-group\">\n"
                        + "<input type=\"hidden\" class=\"form-control form-control-user\" name=\"tipoDato\" value=\"Dato\">\n"
                        + "</div>\n"
                        + "<hr>\n"
                        + "<input type=\"submit\" value=\"Notificar\" class=\"btn btn-primary btn-user btn-block\">\n"
                        + "</form>"
                        + "</div>\n"
                        + "</div>\n"
                        + "<div class=\"col-auto\">\n"
                        + "</div>\n"
                        + "</div>\n"
                        + "</div>\n"
                        + "</div>\n"
                        + "</div>";
            }

            a += "</div>\n";
        }

        return a;
    }

    public static void main(String[] args) throws SQLException {
        //graficarAlertas g = new graficarAlertas();
        //g.graficaAlerta();

    }
}
