package senati.rrhh.servicio;

import senati.rrhh.modelo.Cliente;

import java.util.List;

public interface IClienteServicio {
    public List<Cliente> ListarClientes();
    public Cliente buscarClientePorID(Integer idCliente);
    public Cliente guardarCliente(Cliente cliente);
    public void eliminarCliente(Cliente cliente);
}
