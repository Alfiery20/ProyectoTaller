package LOGIC;

import BEANS.Trabajador;
import DAO.TrabajadorDAOImpl;

import java.util.List;

public class TrabajadorServiceImpl {

    private TrabajadorDAOImpl trabajadorDAOImpl = new TrabajadorDAOImpl();

    public List<Trabajador> list() {
        return trabajadorDAOImpl.list();
    }

    public Trabajador view(String id) {
        return trabajadorDAOImpl.view(id);
    }

    public Trabajador InicioSesion(String corr, String cont) {
        return trabajadorDAOImpl.inicioSesion(corr, cont);
    }
}
