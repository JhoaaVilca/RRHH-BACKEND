package senati.rrhh.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import senati.rrhh.modelo.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente,Integer> {
}
