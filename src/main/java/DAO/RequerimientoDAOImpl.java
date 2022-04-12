package DAO;

import BEANS.Requerimiento;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RequerimientoDAOImpl {

    public List<Requerimiento> list(Integer id) {
        return null;
    }

    public Requerimiento view(Integer id) {
        return null;
    }

    private Requerimiento mapperProyecto(ResultSet rs) throws SQLException {
        Requerimiento requerimiento = Requerimiento.builder()
                .id(rs.getObject("tb_requerimiento_id", Integer.class))
                .nombre(rs.getString("tb_requerimiento_nomb"))
                .estado(rs.getString("tb_requerimiento_estado"))
                .moduloID(rs.getObject("tb_requerimiento_id", Integer.class))
                .build();
        return requerimiento;
    }
}
