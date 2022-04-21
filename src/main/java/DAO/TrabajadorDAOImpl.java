package DAO;

import BEANS.Cliente;
import BEANS.Modulo;
import BEANS.Trabajador;
import CONEXION.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrabajadorDAOImpl {

    public List<Trabajador> list() {
        List<Trabajador> R = new ArrayList<>();
        try {
            Connection Cc = Conexion.conectar();
            String Sql = String.format("SELECT * FROM public.tb_trabajador");
            PreparedStatement Pst = Cc.prepareCall(Sql);
            ResultSet Rs = Pst.executeQuery();
            while (Rs.next()) {
                R.add(mapperTrabajador(Rs));
            }
            Rs.close();
            Cc.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return R;
    }

    public Trabajador view(String id) {
        return null;
    }

    public boolean Nuevo(Trabajador trabajador) {
        boolean R = false;
        try {
            Connection Cc = Conexion.conectar();
            String Sql = "INSERT INTO public.tb_trabajador("
                    + "	tb_trabajador_id, tb_trabajador_dni, tb_trabajador_nomb, tb_trabajador_apell, tb_trabajador_telef, tb_trabajador_corr, tb_trabajador_situa, tb_trabajador_tipo, tb_trabajador_cont)"
                    + "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement Pst = Cc.prepareCall(Sql);
            Pst.setString(1, trabajador.getId());
            Pst.setString(2, trabajador.getDNI());
            Pst.setString(3, trabajador.getNombre());
            Pst.setString(4, trabajador.getApellidos());
            Pst.setString(5, trabajador.getTelefono());
            Pst.setString(6, trabajador.getCorreo());
            Pst.setString(7, trabajador.getSituacion());
            Pst.setString(8, trabajador.getTipo());
            Pst.setString(9, trabajador.getNombre().substring(0, 3) + trabajador.getApellidos().substring(0, 3));
            int n = Pst.executeUpdate();
            if (n > 0) {
                R = true;
            }
            Cc.close();
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return R;
    }

    public boolean Modificar(Trabajador trabajador) {
        boolean R = false;
        try {
            Connection Cc = Conexion.conectar();
            String Sql = "UPDATE public.tb_trabajador"
                    + "	SET tb_trabajador_dni=?, tb_trabajador_nomb=?, tb_trabajador_apell=?, tb_trabajador_telef=?, tb_trabajador_corr=?, tb_trabajador_situa=?, tb_trabajador_tipo=?"
                    + "	WHERE tb_trabajador_id=?;";
            PreparedStatement Pst = Cc.prepareCall(Sql);
            Pst.setString(8, trabajador.getId());
            Pst.setString(1, trabajador.getDNI());
            Pst.setString(2, trabajador.getNombre());
            Pst.setString(3, trabajador.getApellidos());
            Pst.setString(4, trabajador.getTelefono());
            Pst.setString(5, trabajador.getCorreo());
            Pst.setString(6, trabajador.getSituacion());
            Pst.setString(7, trabajador.getTipo());
            int n = Pst.executeUpdate();
            if (n > 0) {
                R = true;
            }
            Cc.close();
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return R;
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
                R = mapperTrabajador(Rs);
            }
            Rs.close();
            Cc.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return R;
    }

    private Trabajador mapperTrabajador(ResultSet rs) throws SQLException {
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
