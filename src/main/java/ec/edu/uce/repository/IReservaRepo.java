package ec.edu.uce.repository;

import java.util.List;

import ec.edu.uce.modelo.Reserva;

public interface IReservaRepo {
	public Reserva buscar(Integer id);
	public List<Reserva> buscarTodos();
	public void actualizar(Reserva e);
	public void eliminar(Integer id);
	public void insertar(Reserva e);
}
