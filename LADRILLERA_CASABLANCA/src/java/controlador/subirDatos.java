/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DTO.ConsumoDTO;
import DTO.produccionDTO;
import com.csvreader.CsvReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Jose
 */
@WebServlet(name = "subirDatos", urlPatterns = {"/subirDatos"})
@MultipartConfig
public class subirDatos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        try {
            Part file = request.getPart("csv");
            InputStream fileContenido = file.getInputStream();
            CsvReader datos = new CsvReader(new InputStreamReader(fileContenido, "UTF-8"));
            datos.readHeaders();
            Connection con = conexion.startConnection();
            
            datos.readRecord();
            if (datos.get(0).equals("Dato")) {
                ConsumoDTO consumo = new ConsumoDTO();
                while (datos.readRecord()) {
                    consumo.AgregarDatos(con, datos.get(0), datos.get(1), datos.get(2), datos.get(3), datos.get(4), datos.get(5), datos.get(6));
                }
            }else if(datos.get(0).equals("Anio")){
                produccionDTO produccion = new produccionDTO();
                while (datos.readRecord()) {                    
                    produccion.AgregarDatos(con, datos.get(0), datos.get(1), datos.get(2), datos.get(3), datos.get(4), datos.get(5), datos.get(6));
                }
            }

            datos.close();
            request.getRequestDispatcher("./menu/excel.jsp").forward(request, response);

        } catch (FileNotFoundException e) {
            request.getRequestDispatcher("./menu/error.jsp").forward(request, response);
        } catch (IOException e) {
            request.getRequestDispatcher("./menu/error.jsp").forward(request, response);
        }catch (Exception ex) {
            request.getRequestDispatcher("./menu/error.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
