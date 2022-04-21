package LOGIC;

import BEANS.Cliente;
import DAO.ClienteDAOImpl;

import java.util.List;

public class ClienteServiceImpl {

    private ClienteDAOImpl clienteDAO = new ClienteDAOImpl();

    public List<Cliente> list() {
        return clienteDAO.list();
    }

    public Cliente view(String id) {
        return clienteDAO.view(id);
    }

    public boolean Nuevo(Cliente cliente) {
        return clienteDAO.Nuevo(cliente);
    }
}
