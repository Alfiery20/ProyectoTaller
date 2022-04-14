package DAO;

import BEANS.Modulo;
import BEANS.Proyecto;
import BEANS.Requerimiento;
import CONEXION.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RequerimientoDAOImpl {

    public List<Requerimiento> list(Integer id) {
        List<Requerimiento> R = new ArrayList<>();
        try {
            Connection Cc = Conexion.conectar();
            String Sql = String.format("SELECT * FROM public.tb_requerimiento where tb_modulo_id = ?");
            PreparedStatement Pst = Cc.prepareCall(Sql);
            Pst.setInt(1, id);
            ResultSet Rs = Pst.executeQuery();
            while (Rs.next()) {
                R.add(mapperRequerimiento(Rs));
            }
            Rs.close();
            Cc.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return R;
    }

    public Requerimiento view(Integer id) {
        Requerimiento R = null;
        try {
            Connection Cc = Conexion.conectar();
            String Sql = String.format("SELECT * FROM public.tb_requerimiento where tb_modulo_id = ?");
            PreparedStatement Pst = Cc.prepareCall(Sql);
            Pst.setInt(1, id);
            ResultSet Rs = Pst.executeQuery();
            while (Rs.next()) {
                R = mapperRequerimiento(Rs);
            }
            Rs.close();
            Cc.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return R;
    }

    public boolean guardar(Requerimiento requerimiento) {
        boolean R = false;
        try {
            Connection Cc = Conexion.conectar();
            String Sql = String.format("INSERT INTO public.tb_requerimiento("
                    + "	tb_requer_id, tb_requer_nombre, tb_requer_estado, tb_modulo_id, tb_reque_desc)"
                    + "	VALUES (?, ?, ?, ?, ?);");
            PreparedStatement Pst = Cc.prepareCall(Sql);
            Pst.setString(1, requerimiento.getId());
            Pst.setString(2, requerimiento.getNombre());
            Pst.setString(3, requerimiento.getEstado());
            Pst.setInt(4, requerimiento.getModuloID());
            Pst.setString(5, requerimiento.getDescripcion());
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

    private Requerimiento mapperRequerimiento(ResultSet rs) throws SQLException {
        Requerimiento requerimiento = Requerimiento.builder()
                .id(rs.getString("tb_requer_id"))
                .nombre(rs.getString("tb_requer_nombre"))
                .estado(rs.getString("tb_requer_estado"))
                .descripcion(rs.getString("tb_reque_desc"))
                .moduloID(rs.getObject("tb_modulo_id", Integer.class))
                .build();
        return requerimiento;
    }
}
