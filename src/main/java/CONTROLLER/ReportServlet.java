/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import BEANS.Modulo;
import BEANS.Proyecto;
import BEANS.Requerimiento;
import LOGIC.ModuloServiceImpl;
import LOGIC.ProyectoServiceImpl;
import LOGIC.RequerimientoServiceImpl;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFileChooser;

/**
 *
 * @author Alfiery Furlong
 */
public class ReportServlet extends HttpServlet {

    private Document Documento = new Document();
    private FileOutputStream Archivo;

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
            ProyectoServiceImpl psi = new ProyectoServiceImpl();
            ModuloServiceImpl msi = new ModuloServiceImpl();
            RequerimientoServiceImpl rs = new RequerimientoServiceImpl();
            List<Proyecto> listPro = psi.list();
            for (Proyecto proyecto : listPro) {
                System.out.println("PROYECTO " + proyecto);
                List<Modulo> liMo = msi.list(proyecto.getId());
                for (Modulo modulo : liMo) {
                    System.out.println("MODULO " + modulo);
                    List<Requerimiento> liRe = rs.list(modulo.getId());
                    for (Requerimiento requerimiento : liRe) {
                        System.out.println("REQUERIMIENTOS " + requerimiento);
                    }
                }
            }
        }

    }

    public void CrearPDF() {
        try {
            JFileChooser File = new JFileChooser();
            String Ruta = "C:";
            Archivo = new FileOutputStream(Ruta + "/" + "PRUEBA" + ".pdf");
            PdfWriter.getInstance(Documento, Archivo);
            Documento.open();
            Documento.add(Chunk.NEWLINE);
            Paragraph Universidad = new Paragraph("UNIVERSIDAD NACIONAL PEDRO RUIZ GALLO");
            Universidad.setAlignment(Element.ALIGN_CENTER);
            Documento.add(Universidad);
            Paragraph Entidad = new Paragraph("RECTORADO");
            Entidad.setAlignment(Element.ALIGN_CENTER);
            Documento.add(Entidad);
            Documento.add(Chunk.NEWLINE);
            Paragraph Texto = new Paragraph("EN EL PRESENTE DOCUMENTO SE HACE ENTREGA DE LA RELACION DE ALUMNOS "
                    + "QUE LOGRARON CUMPLIR CON LOS REQUISITOS MINIMOS PARA ENTRAR A LA COMPETENCIA POR Y HAN"
                    + " ALCANZADO LA MAYORIA DE PUNTAJE COMPITIENDO"
                    + " ENTRE LOS CLASIFICADOS ELIGIENDO ASI A LOS SIGUIENTES ALUMNOS: ");
            Texto.setAlignment(Element.ALIGN_JUSTIFIED);
            Documento.add(Texto);
            Documento.add(Chunk.NEWLINE);
            PdfPTable Table = new PdfPTable(3);
            Table.setWidthPercentage(80);
            PdfPCell Cod = new PdfPCell(new Paragraph("CODIGO"));
            Cod.setBackgroundColor(BaseColor.BLACK);
            PdfPCell Nom = new PdfPCell(new Paragraph("NOMBRE"));
            Nom.setBackgroundColor(BaseColor.CYAN);
            PdfPCell Pun = new PdfPCell(new Paragraph("PUNTAJE"));
            Pun.setBackgroundColor(BaseColor.CYAN);
            Table.addCell(Cod);
            Table.addCell(Nom);
            Table.addCell(Pun);

            Documento.add(Table);
            Documento.add(Chunk.NEWLINE);
            Paragraph Final = new Paragraph("SE FELICITA A LOS ALUMNOS INTEGRANTES DEL PATRON PRESENTADO"
                    + "POR SU CONSTANTE ESFUERZO A LO LARGO DEL DESAROLLO PROFESIONAL");
            Final.setAlignment(Element.ALIGN_JUSTIFIED);
            Documento.add(Final);
            Date Fecha = Calendar.getInstance().getTime();
            Paragraph TFecha = new Paragraph("Lambayeque, ");
            TFecha.setAlignment(Element.ALIGN_RIGHT);
            Documento.add(TFecha);
            Documento.close();
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
            System.out.println("ERROR 2: " + e.getMessage());
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
