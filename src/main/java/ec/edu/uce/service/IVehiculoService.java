package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.modelo.Vehiculo;

public interface IVehiculoService {
	public Vehiculo buscar(Integer id);
	public List<Vehiculo> buscarTodos();
	public void actualizar(Vehiculo e);
	public void eliminar(Integer id);
	public void insertar(Vehiculo e);
	public List<Vehiculo> buscarMarca(String modelo, String marca);
	public Vehiculo buscarPlaca(String placa) ;
	
}
