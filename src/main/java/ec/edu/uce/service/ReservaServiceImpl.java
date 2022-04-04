package ec.edu.uce.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Reserva;
import ec.edu.uce.repository.IReservaRepo;

@Service
public class ReservaServiceImpl implements IReservaService {
	
	@Autowired
	private IReservaRepo estu;
	
	@Override
	public Reserva buscar(Integer id) {
		
		return this.estu.buscar(id);
	}

	@Override
	public List<Reserva> buscarTodos() {
		
		return this.estu.buscarTodos();
	}

	@Override
	public void actualizar(Reserva e) {
		this.estu.actualizar(e);
		
	}

	@Override
	public void eliminar(Integer id) {
		this.estu.eliminar(id);
		
	}

	@Override
	public void insertar(Reserva e) {
		this.estu.insertar(e);
		
	}

	@Override
	public List<Reserva> buscarPorFechas(LocalDateTime fInicio, LocalDateTime fFinal, String placa) {
		return this.estu.buscarPorFechas(fInicio, fFinal, placa);
	}

}
