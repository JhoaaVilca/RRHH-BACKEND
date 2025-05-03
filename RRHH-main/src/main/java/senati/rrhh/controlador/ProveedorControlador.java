package senati.rrhh.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import senati.rrhh.modelo.Proveedor;
import senati.rrhh.servicio.IProveedorServicio;
import senati.rrhh.servicio.ProveedorServicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController

//http://localhost:8080/rrhh-app
@RequestMapping("rrhh-app")
@CrossOrigin(value= "http://localhost:3000")

public class ProveedorControlador {
    private static final Logger logger =
            LoggerFactory.getLogger(ProveedorControlador.class);
    @Autowired
    private IProveedorServicio proveedorsServicio;

    //http://localhost:8080/rrhh-app/proveedors
    @GetMapping("/proveedors")
    public List<Proveedor> obtenerproveedors(){
        var proveedors = proveedorsServicio.ListarProveedor();
        proveedors.forEach(proveedor -> logger.info(proveedor.toString()));
        return proveedors;
    }
    //agregar es un post
    @PostMapping("/proveedors")
    public Proveedor agregarProveedor(@RequestBody Proveedor proveedor){
        return proveedorsServicio.guardarProveedor(proveedor);
    }
    @GetMapping("/proveedors/{id}")
    public ResponseEntity<Proveedor> buscarProveedorId (@PathVariable Integer id){
        Proveedor proveedor = proveedorsServicio.buscarProveedorPorID(id);
        return ResponseEntity.ok(proveedor);
    }
    @PutMapping("proveedors/{id}")
    public ResponseEntity<Proveedor> actualizarProveedor(@PathVariable Integer id,
                                                       @RequestBody Proveedor proveedorUpdate){
        Proveedor proveedor = proveedorsServicio.buscarProveedorPorID(id);
        proveedor.setNombreproveedor(proveedorUpdate.getNombreproveedor());
        proveedor.setNombrecontacto(proveedorUpdate.getNombrecontacto());
        proveedor.setTelefono(proveedor.getTelefono());
        proveedor.setEmail(proveedorUpdate.getEmail());
        proveedor.setDireccion(proveedorUpdate.getDireccion());
        proveedor.setTiempoentrega(proveedorUpdate.getTiempoentrega());

        proveedorsServicio.guardarProveedor(proveedor);
        return ResponseEntity.ok(proveedor);
    }

    @DeleteMapping("proveedor/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarProveedor(@PathVariable Integer id){
        Proveedor proveedor = proveedorsServicio.buscarProveedorPorID(id);
        proveedorsServicio.eliminar(proveedor);
        //imprimir mesanje de confirmacion
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("proveedor Eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
