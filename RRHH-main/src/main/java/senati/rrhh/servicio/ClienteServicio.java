package senati.rrhh.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senati.rrhh.modelo.Cliente;
import senati.rrhh.modelo.Empleado;
import senati.rrhh.repositorio.ClienteRepositorio;
import senati.rrhh.repositorio.EmpleadoRepositorio;

import java.util.List;

@Service

public class ClienteServicio implements IClienteServicio{

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Override
    public List<Cliente> ListarClientes() {
        return clienteRepositorio.findAll();
    }

    @Override
    public Cliente buscarClientePorID(Integer idCliente) {
        Cliente cliente = clienteRepositorio.findById(idCliente).orElse(null);
        return cliente;
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        clienteRepositorio.delete(cliente);

    }

}
