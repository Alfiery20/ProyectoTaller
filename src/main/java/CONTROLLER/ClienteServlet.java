/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import BEANS.Cliente;
import BEANS.Trabajador;
import DAO.TrabajadorDAOImpl;
import LOGIC.ClienteServiceImpl;
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
public class ClienteServlet extends HttpServlet {

    TrabajadorDAOImpl trabajadorDAOImpl = new TrabajadorDAOImpl();
    ClienteServiceImpl clienteServiceImpl = new ClienteServiceImpl();

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
                    ListarClientes(request, response);
                    break;
                case "2":
                    request.getRequestDispatcher("Cliente/NuevoCliente.jsp").forward(request, response);
                    break;
                case "3":
                    NuevoCliente(request, response);
                    break;
                case "4":
                    request.getRequestDispatcher("Cliente/NuevoProgramador.jsp").forward(request, response);
                    break;
            }
        }
    }

    private void ListarClientes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Cliente> list = clienteServiceImpl.list();
        List<Trabajador> listTrab = trabajadorDAOImpl.list();
        request.getSession().setAttribute("lisusu", list);
        request.getSession().setAttribute("listTrab", listTrab);
        request.getRequestDispatcher("Trabajador/NuevoProyecto.jsp").forward(request, response);
    }

    private void NuevoCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String ape = request.getParameter("ape");
        String dir = request.getParameter("dir");
        String dni = request.getParameter("dni");
        String cor = request.getParameter("cor");
        String tel = request.getParameter("tel");
        String tip = request.getParameter("tip");
        Cliente temp = Cliente.builder()
                .DNI(dni)
                .nombre(nom)
                .apellidos(ape)
                .direccion(dir)
                .correo(cor)
                .telefono(tel)
                .situacion(tip)
                .build();
        clienteServiceImpl.Nuevo(temp);
        request.getRequestDispatcher("/Trabajador/Proyectos.jsp").forward(request, response);
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
