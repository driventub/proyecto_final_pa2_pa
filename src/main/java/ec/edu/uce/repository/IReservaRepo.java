package ec.edu.uce.repository;

import java.time.LocalDateTime;
import java.util.List;

import ec.edu.uce.modelo.Reserva;

public interface IReservaRepo {
	public Reserva buscar(Integer id);
	public Reserva buscarNum(String numeroReserva);
	public List<Reserva> buscarTodos();
	public List<Reserva> buscarPorFechas(LocalDateTime fInicio, LocalDateTime fFinal, String placa);
	public void actualizar(Reserva e);
	public void eliminar(Integer id);
	public void insertar(Reserva e);

}
