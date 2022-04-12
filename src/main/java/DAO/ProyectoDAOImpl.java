package DAO;

import BEANS.Proyecto;
import BEANS.Trabajador;
import CONEXION.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProyectoDAOImpl {

    public List<Proyecto> list() {
        List<Proyecto> R = new ArrayList<>();
        try {
            Connection Cc = Conexion.conectar();
            String Sql = String.format("SELECT * FROM public.tb_proyecto");
            PreparedStatement Pst = Cc.prepareCall(Sql);
            ResultSet Rs = Pst.executeQuery();
            while (Rs.next()) {
                R.add(mapperProyecto(Rs));
            }
            Rs.close();
            Cc.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return R;
    }

    public Proyecto view(String id) {
        Proyecto R = null;
        try {
            Connection Cc = Conexion.conectar();
            String Sql = "SELECT * FROM public.tb_proyecto where tb_proyecto_id = ?";
            PreparedStatement Pst = Cc.prepareCall(Sql);
            Pst.setString(1, id);
            ResultSet Rs = Pst.executeQuery();
            while (Rs.next()) {
                R = mapperProyecto(Rs);
            }
            Rs.close();
            Cc.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return R;
    }

    public boolean guardar(Proyecto proyecto) {
        boolean R = false;
        try {
            Connection Cc = Conexion.conectar();
            String Sql = String.format("INSERT INTO public.tb_proyecto("
                    + "tb_proyecto_id, tb_proyecto_nomb, tb_proyecto_durac, tb_proyecto_presu, tb_proyecto_estado, tb_proyecto_inic, tb_proyecto_fin, tb_proyecto_tipo, tb_cliente_dni)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
            PreparedStatement Pst = Cc.prepareCall(Sql);
            Pst.setString(1, proyecto.getId());
            Pst.setString(2, proyecto.getNombre());
            Pst.setString(3, proyecto.getDuracion());
            Pst.setDouble(4, proyecto.getPresupuesto());
            Pst.setString(5, proyecto.getEtado());
            Pst.setDate(6, new Date(proyecto.getFechaIni().getTime()));
            Pst.setDate(7, new Date(proyecto.getFechaTer().getTime()));
            Pst.setString(8, proyecto.getTipo());
            Pst.setString(9, proyecto.getClienteDNI());
            int n = Pst.executeUpdate();
            if (n > 0) {
                R = true;
            }
            Cc.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return R;
    }

    public boolean actualizar(Proyecto proyecto) {
        boolean R = false;
        try {
            Connection Cc = Conexion.conectar();
            String Sql = String.format("UPDATE public.tb_proyecto"
                    + "	SET tb_proyecto_nomb=?, tb_proyecto_durac=?, tb_proyecto_presu=?, tb_proyecto_estado=?, tb_proyecto_inic=?, tb_proyecto_fin=?, tb_proyecto_tipo=?, tb_cliente_dni=?"
                    + "	WHERE tb_proyecto_id=?");
            PreparedStatement Pst = Cc.prepareCall(Sql);
            Pst.setString(1, proyecto.getNombre());
            Pst.setString(2, proyecto.getDuracion());
            Pst.setDouble(3, proyecto.getPresupuesto());
            Pst.setString(4, proyecto.getEtado());
            Pst.setDate(5, new Date(proyecto.getFechaIni().getTime()));
            Pst.setDate(6, new Date(proyecto.getFechaTer().getTime()));
            Pst.setString(7, proyecto.getTipo());
            Pst.setString(8, proyecto.getClienteDNI());
            Pst.setString(9, proyecto.getId());
            int n = Pst.executeUpdate();
            if (n > 0) {
                R = true;
            }
            Cc.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return R;
    }

    public boolean eliminar(String id) {
        boolean R = false;
        try {
            Connection Cc = Conexion.conectar();
            String Sql = String.format("DELETE FROM public.tb_proyecto"
                    + "	WHERE tb_proyecto_id=?");
            PreparedStatement Pst = Cc.prepareCall(Sql);
            Pst.setString(1, id);
            int n = Pst.executeUpdate();
            if (n > 0) {
                R = true;
            }
            Cc.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return R;
    }

    private Proyecto mapperProyecto(ResultSet rs) throws SQLException {
        Proyecto proyecto = Proyecto.builder()
                .id(rs.getString("tb_proyecto_id"))
                .nombre(rs.getString("tb_proyecto_nomb"))
                .duracion(rs.getString("tb_proyecto_durac"))
                .presupuesto(rs.getInt("tb_proyecto_presu"))
                .etado((rs.getString("tb_proyecto_estado")))
                .fechaIni(rs.getDate("tb_proyecto_inic"))
                .fechaTer(rs.getDate("tb_proyecto_fin"))
                .tipo((rs.getString("tb_proyecto_tipo")))
                .clienteDNI(rs.getString("tb_cliente_dni"))
                .build();
        return proyecto;
    }

    private String tipo(String A) {
        switch (A) {
            case "P":
                return "PENDIENTE";
            case "E":
                return "EN PROGRESO";
            case "T":
                return "TERMINADO";
            case "D":
                return "DESAROLLO";
            case "S":
                return "SOPORTE";
            default:
                return "NINGUNO";
        }
    }
}
