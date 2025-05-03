package senati.rrhh.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import senati.rrhh.modelo.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto,Integer> {

}
