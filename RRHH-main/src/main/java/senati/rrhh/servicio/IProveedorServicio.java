package senati.rrhh.servicio;

import senati.rrhh.modelo.Proveedor;

import java.util.List;

public interface IProveedorServicio {
    public List<Proveedor> ListarProveedor();
    public Proveedor buscarProveedorPorID(Integer idProveedor);
    public Proveedor guardarProveedor(Proveedor proveedor);
    public void eliminar(Proveedor proveedor);

}
