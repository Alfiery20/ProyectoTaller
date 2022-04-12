package LOGIC;

import BEANS.Proyecto;
import DAO.ProyectoDAOImpl;

import java.util.List;

public class ProyectoServiceImpl {

    private ProyectoDAOImpl proyectoDAO = new ProyectoDAOImpl();

    public List<Proyecto> list() {
        return proyectoDAO.list();
    }

    public Proyecto view(String id) {
        return proyectoDAO.view(id);
    }

    public boolean Guardar(Proyecto proyecto) {
        return proyectoDAO.guardar(proyecto);
    }

    public boolean Actualizar(Proyecto proyecto) {
        return proyectoDAO.actualizar(proyecto);
    }
    
    public boolean Eliminar(String id){
        return proyectoDAO.eliminar(id);
    }
}
