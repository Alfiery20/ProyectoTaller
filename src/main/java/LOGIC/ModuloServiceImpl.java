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

    public boolean Nuevo(Modulo modulo) {
        return moduloDAO.nuevoModulo(modulo);
    }

    public boolean Editar(Modulo modulo) {
        return moduloDAO.editarModulo(modulo);
    }

    public boolean Eliminar(Integer cod) {
        System.out.println("DENTRO DEL SERVICE");
        return moduloDAO.eliminarModulo(cod);
    }
}
