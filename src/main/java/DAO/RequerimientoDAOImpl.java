package DAO;

import BEANS.Modulo;
import BEANS.Requerimiento;
import CONEXION.Conexion;
import java.sql.Connection;
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
        return null;
    }

    private Requerimiento mapperRequerimiento(ResultSet rs) throws SQLException {
        Requerimiento requerimiento = Requerimiento.builder()
                .id(rs.getObject("tb_requerimiento_id", Integer.class))
                .nombre(rs.getString("tb_requerimiento_nomb"))
                .estado(rs.getString("tb_requerimiento_estado"))
                .moduloID(rs.getObject("tb_requerimiento_id", Integer.class))
                .build();
        return requerimiento;
    }
}
