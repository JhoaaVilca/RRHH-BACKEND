package senati.rrhh.servicio;

import senati.rrhh.modelo.Empleado;

import java.util.List;

public interface IEmpleadoServicio {
    public List<Empleado> ListarEmpleados();
    public Empleado buscarEmpleadoPorID(Integer idEmpleado);
    public Empleado guardarEmpleado(Empleado empleado);
    public void eliminarEmpleado(Empleado empleado);

}
