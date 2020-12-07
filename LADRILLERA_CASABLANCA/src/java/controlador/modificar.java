/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.Usuario;
import DTO.UsuarioDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jose
 */
@WebServlet(name = "modificar", urlPatterns = {"/modificar"})
public class modificar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Usuario us = (Usuario) request.getSession().getAttribute("usuario");
            String[] x = new String[5];

            x[0] = request.getParameter("datoNombre");
            x[1] = request.getParameter("datoCargo");
            x[2] = request.getParameter("datoEmail");
            x[3] = request.getParameter("datoContra");
            x[4] = us.getTipo();

            /*
            x[0] = (request.getParameter("datoNombre") == null)?us.getNombre():request.getParameter("datoNombre");
            x[1] = (request.getParameter("datoCargo") == null)?us.getCargo():request.getParameter("datoCargo");
            x[2] = (request.getParameter("datoEmail") == null)?us.getEmail():request.getParameter("datoEmail");
            x[3] = (request.getParameter("datoContra") == null)?us.getContra():request.getParameter("datoContra");
            x[4] = us.getTipo();
            */
            if(UsuarioDTO.editarUnUsuario(us.getNombre(), us.getContra(), us.getEmail(), x)){
                us = UsuarioDTO.informacionDeUnUsuario(x[2], x[3]);
                request.getSession().setAttribute("usuario", us);
                request.getRequestDispatcher("./menu/datosUsuario.jsp").forward(request, response);
            }else{request.getRequestDispatcher("./menu/error.jsp").forward(request, response);}
            
        } catch (Exception e) {
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
