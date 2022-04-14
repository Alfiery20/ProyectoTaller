package LOGIC;

import BEANS.Requerimiento;
import DAO.RequerimientoDAOImpl;

import java.util.List;

public class RequerimientoServiceImpl {

    private RequerimientoDAOImpl requerimientoDAO = new RequerimientoDAOImpl();

    public List<Requerimiento> list(Integer id) {
        return requerimientoDAO.list(id);
    }

    public Requerimiento view(Integer id) {
        return requerimientoDAO.view(id);
    }

    public boolean Nuevo(Requerimiento requerimiento) {
        return requerimientoDAO.guardar(requerimiento);
    }

}
