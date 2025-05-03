package senati.rrhh.servicio;

import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senati.rrhh.modelo.Producto;
import senati.rrhh.repositorio.ProductoRepositorio;

import java.util.List;

@Service

public class ProductoServicio implements IProductoServicio{

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Override
    public List<Producto> ListarProductos() {
        return productoRepositorio.findAll();
    }

    @Override
    public Producto buscarProductoPorID(Integer idProducto) {
        Producto producto = productoRepositorio.findById(idProducto).orElse(null);
        return producto;
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return productoRepositorio.save(producto);
    }

    @Override
    public void eliminar(Producto producto) {
        productoRepositorio.delete(producto);
    }
}
