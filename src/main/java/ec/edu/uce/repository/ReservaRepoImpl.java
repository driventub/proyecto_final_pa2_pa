package ec.edu.uce.repository;

import java.time.LocalDateTime;
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

	@Override
	public List<Reserva> buscarPorFechas(LocalDateTime fInicio, LocalDateTime fFinal, String placa) {
		        // SELECT * FROM reserva r JOIN vehi_id v WHERE v.placa = 'AEZ-334' 
        // AND NOT (r.rese_fecha_i > '2022-04-30' OR r.rese_fecha_final < '2022-04-09');
		TypedQuery<Reserva> myTypedQuery = (TypedQuery<Reserva>) this.e
				.createQuery("SELECT r FROM Reserva r JOIN r.vehiculo v WHERE v.placa=:placa AND NOT (r.fIngreso > :final OR r.fFinal < :inicio) ",Reserva.class);
				myTypedQuery.setParameter("placa", placa);
				myTypedQuery.setParameter("inicio", fInicio);
				myTypedQuery.setParameter("final", fFinal);

		List<Reserva> l1 = myTypedQuery.getResultList();

		LOG.info("Longitud " + l1.size());
		for(Reserva f : l1) {
			LOG.info(f.toString());
		}
			
			
		return l1;
	}

}
