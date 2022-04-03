package ec.edu.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Reserva;

@Repository
@Transactional
public class ReservaRepoImpl implements IReservaRepo{
	
	private static final Logger LOG = LoggerFactory.getLogger(ReservaRepoImpl.class); 
	
	@PersistenceContext
	private EntityManager e;
	
	@Override
	public Reserva buscar(Integer id) {
		return this.e.find(Reserva.class, id);
	}

	@Override
	public List<Reserva> buscarTodos() {
		TypedQuery<Reserva> myTypedQuery = (TypedQuery<Reserva>) this.e
				.createQuery("SELECT f FROM Reserva f    ",Reserva.class);
		return myTypedQuery.getResultList();
		
	}

	@Override
	public void actualizar(Reserva e) {
		this.e.merge(e);
		
	}

	@Override
	public void eliminar(Integer id) {
		Reserva gBorrar = this.buscar(id);
		this.e.remove(gBorrar);
		
	}

	@Override
	public void insertar(Reserva e) {
		this.e.persist(e);
		
	}

}
