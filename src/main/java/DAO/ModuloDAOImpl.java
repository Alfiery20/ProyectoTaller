package DAO;

import BEANS.Modulo;
import CONEXION.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModuloDAOImpl {

    public List<Modulo> list(String idProyecto) {
        List<Modulo> R = new ArrayList<>();
        try {
            Connection Cc = Conexion.conectar();
            String Sql = String.format("SELECT * FROM public.tb_modulo where tb_modulo_id = ?");
            PreparedStatement Pst = Cc.prepareCall(Sql);
            Pst.setString(1, idProyecto);
            ResultSet Rs = Pst.executeQuery();
            while (Rs.next()) {
                R.add(mapperModulo(Rs));
            }
            Rs.close();
            Cc.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return R;
    }

    public Modulo view(Integer id) {
        return null;
    }

    private Modulo mapperModulo(ResultSet rs) throws SQLException {
        Modulo modulo = Modulo.builder()
                .id(rs.getObject("tb_modulo_id", Integer.class))
                .nombre(rs.getString("tb_modulo_nombre"))
                .duracion(rs.getString("tb_modulo_duracion"))
                .tipo(rs.getString("tb_modulo_tipo"))
                .proyectoID(rs.getObject("tb_proyecto_id", Integer.class))
                .build();
        return modulo;
    }

}
