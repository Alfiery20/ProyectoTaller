package DAO;

import BEANS.Trabajador;
import CONEXION.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TrabajadorDAOImpl {

    public List<Trabajador> list() {
        return null;
    }

    public Trabajador view(String id) {
        return null;
    }

    public Trabajador inicioSesion(String corr, String cont) {
        Trabajador R = null;
        try {
            Connection Cc = Conexion.conectar();
            String Sql = String.format("SELECT * FROM public.tb_trabajador "
                    + "where tb_trabajador_corr = '%s' and tb_trabajador_cont = '%s'", corr, cont);
            PreparedStatement Pst = Cc.prepareCall(Sql);
            ResultSet Rs = Pst.executeQuery();
            while (Rs.next()) {
                R = mapperCliente(Rs);
            }
            Rs.close();
            Cc.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return R;
    }

    private Trabajador mapperCliente(ResultSet rs) throws SQLException {
        Trabajador trabajador = Trabajador.builder()
                .id(rs.getString("tb_trabajador_id"))
                .DNI(rs.getString("tb_trabajador_dni"))
                .nombre(rs.getString("tb_trabajador_nomb"))
                .apellidos(rs.getString("tb_trabajador_apell"))
                .telefono(rs.getString("tb_trabajador_telef"))
                .correo(rs.getString("tb_trabajador_corr"))
                .situacion(rs.getString("tb_trabajador_situa"))
                .tipo(rs.getString("tb_trabajador_tipo"))
                .build();
        return trabajador;
    }

}
