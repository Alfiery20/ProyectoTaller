package LOGIC;

import BEANS.Cliente;
import DAO.ClienteDAOImpl;

import java.util.List;

public class ClienteServiceImpl {

    private ClienteDAOImpl clienteDAO = new ClienteDAOImpl();

    public List<Cliente> list() {
        return clienteDAO.list();
    }

    public Cliente view(Integer id) {
        return clienteDAO.view(id);
    }
}
