/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEANS.Proyecto;
import BEANS.Trabajador;
import BEANS.TrabajadorxProyecto;
import CONEXION.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Alfiery Furlong
 */
public class TrabajadorXProyectoDAOImpl {

    public boolean guardar(TrabajadorxProyecto trabajadorxProyecto) {
        boolean R = false;
        try {
            Connection Cc = Conexion.conectar();
            String Sql = String.format("INSERT INTO public.tb_trababajadorxproyecto("
                    + "	tb_proyecto_id, tb_trabajador_id)"
                    + "	VALUES (?, ?);");
            PreparedStatement Pst = Cc.prepareCall(Sql);
            Pst.setString(1, trabajadorxProyecto.getProyectoId());
            Pst.setString(2, trabajadorxProyecto.getTrabajadorId());
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

    public TrabajadorxProyecto view(String idProyecto) {
        TrabajadorxProyecto R = null;
        try {
            Connection Cc = Conexion.conectar();
            String Sql = String.format("select * from tb_trababajadorxproyecto where tb_proyecto_id = ?");
            PreparedStatement Pst = Cc.prepareCall(Sql);
            Pst.setString(1, idProyecto);
            ResultSet rs = Pst.executeQuery();
            while (rs.next()) {
                R = mapperTrabajadorXProyecto(rs);
            }
            Cc.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return R;
    }

    private TrabajadorxProyecto mapperTrabajadorXProyecto(ResultSet rs) throws SQLException {
        TrabajadorxProyecto TXP = TrabajadorxProyecto.builder()
                .proyectoId(rs.getString("tb_proyecto_id"))
                .trabajadorId(rs.getString("tb_trabajador_id"))
                .build();
        return TXP;
    }

}
