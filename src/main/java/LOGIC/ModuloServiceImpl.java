package LOGIC;

import BEANS.Modulo;
import DAO.ModuloDAOImpl;

import java.util.List;

public class ModuloServiceImpl {

    private final ModuloDAOImpl moduloDAO = new ModuloDAOImpl();

    public List<Modulo> list(String idProyecto) {
        return moduloDAO.list(idProyecto);
    }

    public Modulo view(Integer id) {
        return moduloDAO.view(id);
    }
}
