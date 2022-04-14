/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import BEANS.Modulo;
import BEANS.Requerimiento;
import LOGIC.ModuloServiceImpl;
import LOGIC.RequerimientoServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alfiery Furlong
 */
public class RequerimientosServlet extends HttpServlet {

    RequerimientoServiceImpl requerimientoServiceImpl = new RequerimientoServiceImpl();
    ModuloServiceImpl moduloServiceImpl = new ModuloServiceImpl();

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String Dato = request.getParameter("Dato");
            switch (Dato) {
                case "1":
                    Modulo tempo = moduloServiceImpl.view(Integer.parseInt(request.getParameter("id")));
                    request.getSession().setAttribute("modtemp", tempo);
                    request.getRequestDispatcher("/Trabajador/NuevoRequerimiento.jsp").forward(request, response);
                    break;
                case "2":
                    NuevoRequerimiento(request, response);
                    break;
            }
        }
    }

    private void NuevoRequerimiento(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cod = request.getParameter("cod");
        String nom = request.getParameter("nom");
        String est = request.getParameter("tip");
        String des = request.getParameter("des");
        Modulo tempo = (Modulo) request.getSession().getAttribute("modtemp");
        Requerimiento requerimiento = Requerimiento.builder()
                .id(cod)
                .nombre(nom)
                .estado(est)
                .descripcion(des)
                .moduloID(tempo.getId())
                .build();
        requerimientoServiceImpl.Nuevo(requerimiento);
        List<Requerimiento> listReq = requerimientoServiceImpl.list(tempo.getId());
        request.getSession().setAttribute("listReq", listReq);
        request.getRequestDispatcher("/Trabajador/ModificarModulo.jsp").forward(request, response);
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
