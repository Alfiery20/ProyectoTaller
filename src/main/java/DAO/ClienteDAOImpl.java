package DAO;

import BEANS.Cliente;
import BEANS.Proyecto;
import CONEXION.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl {

    public List<Cliente> list() {
        List<Cliente> R = new ArrayList<>();
        try {
            Connection Cc = Conexion.conectar();
            String Sql = String.format("SELECT * FROM public.tb_cliente");
            PreparedStatement Pst = Cc.prepareCall(Sql);
            ResultSet Rs = Pst.executeQuery();
            while (Rs.next()) {
                R.add(mapperCliente(Rs));
            }
            Rs.close();
            Cc.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return R;
    }

    public boolean Nuevo(Cliente cliente) {
        boolean R = false;
        try {
            Connection Cc = Conexion.conectar();
            String Sql = "INSERT INTO public.tb_cliente("
                    + "	tb_cliente_dni, tb_cliente_nomb, tb_cliente_apel, tb_cliente_direc, tb_cliente_telef, tb_cliente_correo, tb_cliente_situa)"
                    + "	VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement Pst = Cc.prepareCall(Sql);
            Pst.setString(1, cliente.getDNI());
            Pst.setString(2, cliente.getNombre());
            Pst.setString(3, cliente.getApellidos());
            Pst.setString(4, cliente.getDireccion());
            Pst.setString(5, cliente.getTelefono());
            Pst.setString(6, cliente.getCorreo());
            Pst.setString(7, cliente.getSituacion());
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

    public Cliente view(String id) {
        Cliente R = null;
        try {
            Connection Cc = Conexion.conectar();
            String Sql = String.format("SELECT * FROM public.tb_cliente where tb_cliente_dni = ?");
            PreparedStatement Pst = Cc.prepareCall(Sql);
            Pst.setString(1, id);
            ResultSet Rs = Pst.executeQuery();
            while (Rs.next()) {
                R = mapperCliente(Rs);
            }
            Rs.close();
            Cc.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return R;
    }

    private Cliente mapperCliente(ResultSet rs) throws SQLException {
        Cliente cliente = Cliente.builder()
                .DNI(rs.getString("tb_cliente_dni"))
                .nombre(rs.getString("tb_cliente_nomb"))
                .apellidos(rs.getString("tb_cliente_apel"))
                .direccion(rs.getString("tb_cliente_direc"))
                .telefono(rs.getString("tb_cliente_telef"))
                .correo(rs.getString("tb_cliente_correo"))
                .situacion(rs.getString("tb_cliente_situa"))
                .build();
        return cliente;
    }

}
