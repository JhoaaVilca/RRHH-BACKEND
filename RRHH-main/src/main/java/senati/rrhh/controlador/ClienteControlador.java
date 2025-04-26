package senati.rrhh.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import senati.rrhh.modelo.Cliente;
import senati.rrhh.modelo.Empleado;
import senati.rrhh.servicio.IClienteServicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController

//http://localhost:8080/rrhh-app
@RequestMapping("rrhh-app")
@CrossOrigin(value= "http://localhost:3000")

public class ClienteControlador {
    private static final Logger logger =
            LoggerFactory.getLogger(ClienteControlador.class);
    @Autowired
    private IClienteServicio clienteServicio;

    //http://localhost:8080/rrhh-app/cliente
    @GetMapping("/cliente")
    public List<Cliente> obtenerclientes(){
        var clientes = clienteServicio.ListarClientes();
        clientes.forEach(Cliente -> logger.info(clientes.toString()));
        return clientes;
    }

    @PostMapping("/cliente")
    public Cliente agregarCliente(@RequestBody Cliente cliente){
        return clienteServicio.guardarCliente(cliente);
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<Cliente> buscarClienteId (@PathVariable Integer id){
        Cliente cliente = clienteServicio.buscarClientePorID(id);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("cliente/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Integer id,
                                                       @RequestBody Cliente clienteUpdate){
        Cliente cliente = clienteServicio.buscarClientePorID(id);
        cliente.setApellido(clienteUpdate.getApellido());
        cliente.setNombre(clienteUpdate.getNombre());
        cliente.setTelefono(clienteUpdate.getTelefono());
        cliente.setDireccion(clienteUpdate.getDireccion());
        cliente.setEmail(clienteUpdate.getEmail());

        clienteServicio.guardarCliente(cliente);
        return ResponseEntity.ok(cliente);
    }
    @DeleteMapping("cliente/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarCliente(@PathVariable Integer id){
        Cliente cliente = clienteServicio.buscarClientePorID(id);
        clienteServicio.eliminarCliente(cliente);
        //imprimir mesanje de confirmacion
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("cliente Eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
