package senati.rrhh.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import senati.rrhh.modelo.Empleado;
import senati.rrhh.servicio.IEmpleadoServicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController

//http://localhost:8080/rrhh-app
@RequestMapping("rrhh-app")
@CrossOrigin(value= "http://localhost:3000")

public class EmpleadoControlador {
    private static final Logger logger =
            LoggerFactory.getLogger(EmpleadoControlador.class);
    @Autowired
    private IEmpleadoServicio empleadoServicio;

    //http://localhost:8080/rrhh-app/empleados
    @GetMapping("/empleados")
    public List<Empleado> obtenerempleadoss(){
        var empleados = empleadoServicio.ListarEmpleados();
        empleados.forEach(empleado -> logger.info(empleado.toString()));
        return empleados;
    }
    //agregar es un post
    @PostMapping("/empleados")
    public Empleado agregarEmpleado(@RequestBody Empleado empleado){
        return empleadoServicio.guardarEmpleado(empleado);
    }
    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> buscarEmpleadoId (@PathVariable Integer id){
        Empleado empleado = empleadoServicio.buscarEmpleadoPorID(id);
        return ResponseEntity.ok(empleado);
    }
    @PutMapping("empleados/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Integer id,
                                                       @RequestBody Empleado empleadoUpdate){
        Empleado empleado = empleadoServicio.buscarEmpleadoPorID(id);
        empleado.setApellido(empleadoUpdate.getApellido());
        empleado.setNombre(empleadoUpdate.getNombre());
        empleado.setArea(empleadoUpdate.getArea());
        empleado.setEmail(empleado.getEmail());
        empleado.setSueldo(empleadoUpdate.getSueldo());
        empleado.setDireccion(empleadoUpdate.getDireccion());
        empleado.setTelefono(empleadoUpdate.getTelefono());

        empleadoServicio.guardarEmpleado(empleado);
        return ResponseEntity.ok(empleado);
    }

    @DeleteMapping("empleados/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarEmpleado(@PathVariable Integer id){
        Empleado empleado = empleadoServicio.buscarEmpleadoPorID(id);
        empleadoServicio.eliminarEmpleado(empleado);
        //imprimir mesanje de confirmacion
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("empleado Eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
