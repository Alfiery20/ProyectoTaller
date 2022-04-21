/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGIC;

import BEANS.TrabajadorxProyecto;
import DAO.TrabajadorXProyectoDAOImpl;

/**
 *
 * @author Alfiery Furlong
 */
public class TrabajadorXProyectoServiceImpl {

    TrabajadorXProyectoDAOImpl trabajadorXProyectoDAOImpl = new TrabajadorXProyectoDAOImpl();

    public boolean Guardar(TrabajadorxProyecto trabajadorxProyecto) {
        return trabajadorXProyectoDAOImpl.guardar(trabajadorxProyecto);
    }

    public TrabajadorxProyecto view(String id) {
        return trabajadorXProyectoDAOImpl.view(id);
    }

}
