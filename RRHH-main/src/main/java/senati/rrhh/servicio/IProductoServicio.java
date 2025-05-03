package senati.rrhh.servicio;

import senati.rrhh.modelo.Producto;

import java.util.List;

public interface IProductoServicio {
    public List<Producto> ListarProductos();
    public Producto buscarProductoPorID(Integer idProducto);
    public Producto guardarProducto(Producto producto);
    public void eliminar(Producto producto);

}
