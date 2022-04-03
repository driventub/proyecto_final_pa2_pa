package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.modelo.Reserva;

public interface IReservaService {
	public Reserva buscar(Integer id);
	public List<Reserva> buscarTodos();
	public void actualizar(Reserva e);
	public void eliminar(Integer id);
	public void insertar(Reserva e);
}
