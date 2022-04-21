/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import BEANS.Cliente;
import BEANS.Modulo;
import BEANS.Proyecto;
import BEANS.Trabajador;
import BEANS.TrabajadorxProyecto;
import LOGIC.ClienteServiceImpl;
import LOGIC.ModuloServiceImpl;
import LOGIC.ProyectoServiceImpl;
import LOGIC.TrabajadorServiceImpl;
import LOGIC.TrabajadorXProyectoServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alfiery Furlong
 */
public class ProyectoServlet extends HttpServlet {

    TrabajadorServiceImpl trabajadorServiceImpl = new TrabajadorServiceImpl();
    ClienteServiceImpl clienteServiceImpl = new ClienteServiceImpl();
    ProyectoServiceImpl proyectoServiceImpl = new ProyectoServiceImpl();
    ModuloServiceImpl moduloServiceImpl = new ModuloServiceImpl();
    TrabajadorXProyectoServiceImpl proyectoServiceImpl1 = new TrabajadorXProyectoServiceImpl();

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
                    NuevoProyecto(request, response);
                    break;
                case "2":
                    request.getRequestDispatcher("/Trabajador/Proyectos.jsp").forward(request, response);
                    break;
                case "3":
                    Proyecto prueba = proyectoServiceImpl.view(request.getParameter("id"));
                    request.getSession().setAttribute("prote", prueba);
                    List<Cliente> list = clienteServiceImpl.list();
                    List<Modulo> listModu = moduloServiceImpl.list(prueba.getId());
                    List<Trabajador> listTrab = trabajadorServiceImpl.list();
                    System.out.println("ID DEL PROYECTO: " + prueba.getId());
                    TrabajadorxProyecto TXP = proyectoServiceImpl1.view(prueba.getId());
                    System.out.println("TXP: " + TXP);
                    request.getSession().setAttribute("TXP", TXP);
                    request.getSession().setAttribute("lisusu", list);
                    request.getSession().setAttribute("listmodu", listModu);
                    request.getSession().setAttribute("listTrab", listTrab);
                    request.getRequestDispatcher("/Trabajador/ModificarProyecto.jsp").forward(request, response);
                    break;
                case "4":
                    EditarProyecto(request, response);
                    break;
                case "5":
                    String cod = request.getParameter("id");
                    boolean r = proyectoServiceImpl.Eliminar(cod);
                    if (r) {
                        List<Proyecto> lpro = proyectoServiceImpl.list();
                        request.getSession().setAttribute("proyectos", lpro);
                        request.getRequestDispatcher("/Trabajador/Proyectos.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("/Trabajador/NuevoProyecto.jsp").forward(request, response);
                    }
                    break;
            }
        }
    }

    private void NuevoProyecto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String nom = request.getParameter("nom");
        String cod = request.getParameter("cod");
        String dur = request.getParameter("dur");
        String pre = request.getParameter("pre");
        String est = request.getParameter("est");
        String fin = request.getParameter("fin");
        String fet = request.getParameter("fet");
        String tip = request.getParameter("tip");
        String cli = request.getParameter("cli");
        String tra = request.getParameter("tra");

        try {
            Proyecto pro = Proyecto.builder()
                    .nombre(nom)
                    .id(cod)
                    .duracion(dur)
                    .presupuesto(Double.parseDouble(pre))
                    .etado(est)
                    .fechaIni(sdf.parse(fin))
                    .fechaTer(sdf.parse(fet))
                    .tipo(tip)
                    .clienteDNI(cli)
                    .build();
            boolean r = proyectoServiceImpl.Guardar(pro);

            TrabajadorxProyecto tp = TrabajadorxProyecto.builder()
                    .proyectoId(cod)
                    .trabajadorId(tra)
                    .build();
            System.out.println("CODIGO PROYECTO: " + cod);
            System.out.println("CODIGO TRABAJADOR: " + tra);
            boolean a = proyectoServiceImpl1.Guardar(tp);
            if (r && a) {
                List<Proyecto> lpro = proyectoServiceImpl.list();
                request.getSession().setAttribute("proyectos", lpro);
                request.getRequestDispatcher("/Trabajador/Proyectos.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/Trabajador/NuevoProyecto.jsp").forward(request, response);
            }
        } catch (ParseException ex) {
            System.out.println("ERROR " + ex.getMessage());
            request.getRequestDispatcher("/Trabajador/NuevoProyecto.jsp").forward(request, response);
        }
    }

    private void EditarProyecto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String nom = request.getParameter("nom");
        String cod = request.getParameter("cod");
        String dur = request.getParameter("dur");
        String pre = request.getParameter("pre");
        String est = request.getParameter("est");
        String fin = request.getParameter("fin");
        String fet = request.getParameter("fet");
        String tip = request.getParameter("tip");
        String cli = request.getParameter("cli");
        Proyecto pro;
        try {
            pro = Proyecto.builder()
                    .nombre(nom)
                    .id(cod)
                    .duracion(dur)
                    .presupuesto(Double.parseDouble(pre))
                    .etado(est)
                    .fechaIni(sdf.parse(fin))
                    .fechaTer(sdf.parse(fet))
                    .tipo(tip)
                    .clienteDNI(cli)
                    .build();
            boolean r = proyectoServiceImpl.Actualizar(pro);
            if (r) {
                List<Proyecto> lpro = proyectoServiceImpl.list();
                request.getSession().setAttribute("proyectos", lpro);
                request.getRequestDispatcher("/Trabajador/Proyectos.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/Trabajador/NuevoProyecto.jsp").forward(request, response);
            }
        } catch (ParseException ex) {
            System.out.println("ERROR " + ex.getMessage());
            request.getRequestDispatcher("/Trabajador/NuevoProyecto.jsp").forward(request, response);
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
