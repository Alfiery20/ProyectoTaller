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

    public Cliente view(Integer id) {
        return null;
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
