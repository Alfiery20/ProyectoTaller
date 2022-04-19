/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import BEANS.Proyecto;
import BEANS.Trabajador;
import LOGIC.ProyectoServiceImpl;
import LOGIC.TrabajadorServiceImpl;
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
public class TrabajadorServlet extends HttpServlet {

    TrabajadorServiceImpl trabajadorService = new TrabajadorServiceImpl();
    ProyectoServiceImpl proyectoServiceImpl = new ProyectoServiceImpl();

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
            String dato = request.getParameter("Dato");
            switch (dato) {
                case "1":
                    InicioSesion(request, response);
            }
        } catch (IOException ex) {
            System.out.println("ERROR 1:" + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("ERROR 2:" + ex);
        }

    }

    private void InicioSesion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String corr = request.getParameter("corr");
        String cont = request.getParameter("cont");
        Trabajador temp = trabajadorService.InicioSesion(corr, cont);
        List<Proyecto> lpro = proyectoServiceImpl.list();
        if (temp == null) {
            System.out.println("DENTRO DEL NULL");
            request.getSession().setAttribute("msj", "INICIO SESION FALLADO");
            System.out.println("DESPUES DE GUARDAR MENSAJE");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("usu", temp);
            request.getSession().setAttribute("proyectos", lpro);
            request.getSession().setAttribute("msj", "INICIO SESION EXITOSO");
            request.getRequestDispatcher("/Trabajador/Proyectos.jsp").forward(request, response);
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
