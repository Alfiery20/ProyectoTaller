package DAO;

import BEANS.Modulo;
import BEANS.Proyecto;
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
            String Sql = String.format("SELECT * FROM public.tb_modulo where tb_proyecto_id = ?");
            PreparedStatement Pst = Cc.prepareCall(Sql);
            Pst.setString(1, idProyecto);
            ResultSet Rs = Pst.executeQuery();
            while (Rs.next()) {
                R.add(mapperModulo(Rs));
            }
            Rs.close();
            Cc.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return R;
    }

    public Modulo view(Integer id) {
        Modulo R = null;
        try {
            Connection Cc = Conexion.conectar();
            String Sql = "SELECT * FROM public.tb_modulo where tb_modulo_id = ?";
            PreparedStatement Pst = Cc.prepareCall(Sql);
            Pst.setInt(1, id);
            ResultSet Rs = Pst.executeQuery();
            while (Rs.next()) {
                R = mapperModulo(Rs);
            }
            Rs.close();
            Cc.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return R;
    }

    public boolean nuevoModulo(Modulo modulo) {
        boolean R = false;
        try {
            Connection Cc = Conexion.conectar();
            String Sql = String.format("INSERT INTO public.tb_modulo(tb_modulo_id, tb_modulo_nombre, tb_modulo_duracion, tb_modulo_tipo,"
                    + " tb_proyecto_id) VALUES (?, ?, ?, ?, ?)");
            PreparedStatement Pst = Cc.prepareCall(Sql);
            Pst.setObject(1, modulo.getId());
            Pst.setString(2, modulo.getNombre());
            Pst.setString(3, modulo.getDuracion());
            Pst.setString(4, modulo.getTipo());
            Pst.setString(5, modulo.getProyectoID());

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

    public boolean editarModulo(Modulo modulo) {
        boolean R = false;
        System.out.println("MODIFCAR DAO, SI ENTROOOOOO");
        try {
            System.out.println("ENTRE AL DAO 1");
            Connection Cc = Conexion.conectar();
            System.out.println("ENTRE AL DAO 2");
            String Sql = String.format("UPDATE public.tb_modulo"
                    + "	SET tb_modulo_nombre=?, tb_modulo_duracion=?, tb_modulo_tipo=?, tb_proyecto_id=?"
                    + "	WHERE tb_modulo_id=?;");
            System.out.println("ENTRE AL DAO 3");
            PreparedStatement Pst = Cc.prepareCall(Sql);
            System.out.println("ENTRE AL DAO 4:" + modulo);
            Pst.setString(1, modulo.getNombre());
            System.out.println("ENTRE AL DAO 5: " + modulo.getNombre());
            Pst.setString(2, modulo.getDuracion());
            System.out.println("ENTRE AL DAO 6: " + modulo.getDuracion());
            Pst.setString(3, modulo.getTipo());
            System.out.println("ENTRE AL DAO 7: " + modulo.getTipo());
            Pst.setString(4, modulo.getProyectoID());
            System.out.println("ENTRE AL DAO 8: " + modulo.getProyectoID());
            Pst.setObject(5, modulo.getId());
            System.out.println("ENTRE AL DAO 9: " + modulo.getId());

            int n = Pst.executeUpdate();
            System.out.println("DESPUES DEL UPDATE");
            if (n > 0) {
                R = true;
            }
            Cc.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return R;
    }

    public boolean eliminarModulo(Integer cod) {
        boolean R = false;
        System.out.println("DENTRO DEL DAO");
        try {
            Connection Cc = Conexion.conectar();
            String Sql = String.format("DELETE FROM public.tb_modulo WHERE tb_modulo_id=?;");
            PreparedStatement Pst = Cc.prepareCall(Sql);
            Pst.setObject(1, cod);
            int n = Pst.executeUpdate();
            if (n > 0) {
                R = true;
                System.out.println("RESPUESTA DEL UPDATE: " + n);
            }
            Cc.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return R;
    }

    private Modulo mapperModulo(ResultSet rs) throws SQLException {
        Modulo modulo = Modulo.builder()
                .id(rs.getObject("tb_modulo_id", Integer.class))
                .nombre(rs.getString("tb_modulo_nombre"))
                .duracion(rs.getString("tb_modulo_duracion"))
                .tipo(rs.getString("tb_modulo_tipo"))
                .proyectoID(rs.getString("tb_proyecto_id"))
                .build();
        return modulo;
    }

}
