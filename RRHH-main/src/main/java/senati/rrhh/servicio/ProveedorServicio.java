package senati.rrhh.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import senati.rrhh.modelo.Proveedor;

import senati.rrhh.repositorio.ProveedorRepositorio;

import java.util.List;

@Service

public class ProveedorServicio implements IProveedorServicio{

    @Autowired
    private ProveedorRepositorio proveedorRepositorio;

    @Override
    public List<Proveedor> ListarProveedor() {
        return proveedorRepositorio.findAll();
    }

    @Override
    public Proveedor buscarProveedorPorID(Integer idProveedor) {
        Proveedor proveedor = proveedorRepositorio.findById(idProveedor).orElse(null);
        return proveedor;
    }

    @Override
    public Proveedor guardarProveedor(Proveedor proveedor) {
        return proveedorRepositorio.save(proveedor);
    }

    @Override
    public void eliminar(Proveedor proveedor) {
        proveedorRepositorio.delete(proveedor);
    }
}
