package LOGIC;

import BEANS.Requerimiento;
import DAO.RequerimientoDAOImpl;

import java.util.List;

public class RequerimientoServiceImpl {

    private RequerimientoDAOImpl requerimientoDAO = new RequerimientoDAOImpl();

    public List<Requerimiento> list(Integer id) {
        return requerimientoDAO.list(id);
    }

    public Requerimiento view(String id) {
        return requerimientoDAO.view(id);
    }

    public boolean Nuevo(Requerimiento requerimiento) {
        return requerimientoDAO.guardar(requerimiento);
    }

    public boolean Editar(Requerimiento requerimiento) {
        return requerimientoDAO.Editar(requerimiento);
    }

}
