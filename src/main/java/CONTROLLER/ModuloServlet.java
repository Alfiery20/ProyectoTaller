/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import BEANS.Modulo;
import LOGIC.ModuloServiceImpl;
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
public class ModuloServlet extends HttpServlet {

    private ModuloServiceImpl moduloServiceImpl = new ModuloServiceImpl();

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
                    request.getSession().setAttribute("proyectoTempo", request.getParameter("id"));
                    request.getRequestDispatcher("/Trabajador/NuevoModulo.jsp").forward(request, response);
                    break;
                case "2":
                    System.out.println("RECIEN ENTRA AL SERVLET");
                    NuevoModulo(request, response);
                    break;
                case "3":
                    request.getRequestDispatcher("/Trabajador/ModificarModulo.jsp").forward(request, response);
                    break;
                case "4":
                    EditarModulo(request, response);
                    break;
                case "5":
                    System.out.println("ENTRO A SERVLET");
                    ElminarModulo(request, response);
                    break;
            }
        }
    }

    private void NuevoModulo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer cod = Integer.parseInt(request.getParameter("cod"));
        String nom = request.getParameter("nom");
        String dur = request.getParameter("dur");
        String tip = request.getParameter("tip");
        String idp = (String) request.getSession().getAttribute("proyectoTempo");

        Modulo modulo = Modulo.builder()
                .id(cod)
                .nombre(nom)
                .duracion(dur)
                .tipo(tip)
                .proyectoID(idp)
                .build();
        moduloServiceImpl.Nuevo(modulo);
        List<Modulo> listModu = moduloServiceImpl.list(idp);
        request.getSession().setAttribute("listmodu", listModu);
        request.getRequestDispatcher("/Trabajador/ModificarProyecto.jsp").forward(request, response);
    }

    private void EditarModulo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer cod = Integer.parseInt(request.getParameter("cod"));
        String nom = request.getParameter("nom");
        String dur = request.getParameter("dur");
        String tip = request.getParameter("tip");
        String idp = (String) request.getSession().getAttribute("proyectoTempo");

        Modulo modulo = Modulo.builder()
                .id(cod)
                .nombre(nom)
                .duracion(dur)
                .tipo(tip)
                .proyectoID(idp)
                .build();
        moduloServiceImpl.Editar(modulo);
        List<Modulo> listModu = moduloServiceImpl.list(idp);
        request.getSession().setAttribute("listmodu", listModu);
        request.getRequestDispatcher("/Trabajador/ModificarProyecto.jsp").forward(request, response);
    }

    private void ElminarModulo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("SERVLET ELIMINAR");
        Integer cod = Integer.parseInt(request.getParameter("id"));
        System.out.println("CODIGO: " + cod);
        moduloServiceImpl.Eliminar(cod);
        System.out.println("DESPUES DEL SERVICE");
        String idp = (String) request.getSession().getAttribute("proyectoTempo");
        List<Modulo> listModu = moduloServiceImpl.list(idp);
        request.getSession().setAttribute("listmodu", listModu);
        request.getRequestDispatcher("/Trabajador/ModificarProyecto.jsp").forward(request, response);
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
