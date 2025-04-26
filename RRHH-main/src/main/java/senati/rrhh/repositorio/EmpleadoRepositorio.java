package senati.rrhh.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import senati.rrhh.modelo.Empleado;

public interface EmpleadoRepositorio extends JpaRepository<Empleado,Integer> {

}
