package senati.rrhh.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import senati.rrhh.modelo.Producto;
import senati.rrhh.servicio.IProductoServicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController

//http://localhost:8080/rrhh-app
@RequestMapping("rrhh-app")
@CrossOrigin(value= "http://localhost:3000")

public class ProductoControlador {
    private static final Logger logger =
            LoggerFactory.getLogger(ProductoControlador.class);
    @Autowired
    private IProductoServicio productoServicio;

    //http://localhost:8080/rrhh-app/productos
    @GetMapping("/productos")
    public List<Producto> obtenerproductos(){
        var productos = productoServicio.ListarProductos();
        productos.forEach(producto -> logger.info(producto.toString()));
        return productos;
    }
    //agregar es un post
    @PostMapping("/productos")
    public Producto agregarProducto(@RequestBody Producto producto){
        return productoServicio.guardarProducto(producto);
    }
    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> buscarProductoId (@PathVariable Integer id){
        Producto producto = productoServicio.buscarProductoPorID(id);
        return ResponseEntity.ok(producto);
    }
    @PutMapping("productos/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Integer id,
                                                       @RequestBody Producto productoUpdate){
        Producto producto = productoServicio.buscarProductoPorID(id);
        producto.setNombre(productoUpdate.getNombre());
        producto.setDescripcion(productoUpdate.getDescripcion());
        producto.setCantidad(producto.getCantidad());
        producto.setPrecio(productoUpdate.getPrecio());
        producto.setCategoria(productoUpdate.getCategoria());

        productoServicio.guardarProducto(producto);
        return ResponseEntity.ok(producto);
    }

    @DeleteMapping("productos/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarProducto(@PathVariable Integer id){
        Producto producto = productoServicio.buscarProductoPorID(id);
        productoServicio.eliminar(producto);
        //imprimir mesanje de confirmacion
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("producto Eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
