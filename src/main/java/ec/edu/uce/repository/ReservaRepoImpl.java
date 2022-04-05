package ec.edu.uce.repository;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.ReporteClientesVIP;
import ec.edu.uce.modelo.ReporteVehiculoVIP;
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

	@Override
	public Reserva buscarNum(String numeroReserva) {
		TypedQuery<Reserva> myTypedQuery = (TypedQuery<Reserva>) this.e
				.createQuery("SELECT r FROM Reserva r WHERE r.numero=:num",Reserva.class);
				myTypedQuery.setParameter("num", numeroReserva);
				Reserva r = myTypedQuery.getSingleResult() ;
				LOG.info(r.toString());
		return r;
	}

	@Override
	public List<Reserva> reporteReserva(LocalDateTime fInicio, LocalDateTime fFinal) {
		TypedQuery<Reserva> myTypedQuery = (TypedQuery<Reserva>) this.e
				.createQuery("SELECT r FROM Reserva r  WHERE NOT (r.fIngreso > :final OR r.fFinal < :inicio) ",Reserva.class);
				// SELECT id FROM things    WHERE MONTH(happened_at) = 1 AND YEAR(happened_at) = 2009

				myTypedQuery.setParameter("inicio", fInicio);
				myTypedQuery.setParameter("final", fFinal);

		List<Reserva> l1 = myTypedQuery.getResultList();

		LOG.info("Longitud " + l1.size());
		for(Reserva f : l1) {
			LOG.info(f.toString());
		}
			
			
		return l1;
		
	}

	@Override
	public List<ReporteClientesVIP> reportarCliente() {
		// SELECT c.clie_id, SUM(r.rese_val_sub) AS Subtotal, SUM(r.rese_val_total) AS total
		// FROM Reserva r inner join Cliente c
		// on c.clie_id = r.rese_id 

		// GROUP BY c.clie_id;	
		TypedQuery<ReporteClientesVIP> myTypedQuery = (TypedQuery<ReporteClientesVIP>) this.e
			.createQuery("SELECT NEW  ec.edu.uce.modelo.ReporteClientesVIP(SUM(f.valorSubtotal), SUM(f.valorTotal), c.cedula) FROM Reserva f JOIN f.cliente c GROUP BY c.cedula	ORDER BY SUM(f.valorTotal) DESC",ReporteClientesVIP.class);
			List<ReporteClientesVIP> l1 = myTypedQuery.getResultList();

			LOG.info("Longitud " + l1.size());
			for(ReporteClientesVIP f : l1) {
				LOG.info(f.toString());
			}
				
				
			return l1;
	}

	@Override
	public List<ReporteVehiculoVIP> reportarVehiculo(Integer mes, Integer anho) {
		LocalDateTime ultimo = ultimoDia(mes,anho);
		LocalDateTime primer = primerDia(mes,anho);

		TypedQuery<ReporteVehiculoVIP> myTypedQuery = (TypedQuery<ReporteVehiculoVIP>) this.e
			.createQuery("SELECT NEW  ec.edu.uce.modelo.ReporteVehiculoVIP( c.placa,SUM(f.valorICE), SUM(f.valorTotal)) FROM Reserva f JOIN f.vehiculo c WHERE NOT (f.fIngreso > :final OR f.fFinal < :inicio)    GROUP BY c.placa ORDER BY SUM(f.valorTotal) DESC",ReporteVehiculoVIP.class);
			myTypedQuery.setParameter("inicio", primer);
			myTypedQuery.setParameter("final", ultimo);

			List<ReporteVehiculoVIP> l1 = myTypedQuery.getResultList();

			LOG.info("Longitud " + l1.size());
			for(ReporteVehiculoVIP f : l1) {
				LOG.info(f.toString());
			}
				
				
			return l1;
	}

	@Override
	public LocalDateTime ultimoDia(Integer mes, Integer anho) {
		TemporalAdjuster temporalAdjuster = TemporalAdjusters.lastDayOfMonth();
		
		LocalDateTime f = LocalDateTime.of(anho, mes, 01, 23, 59);
		
		LocalDateTime result = f.with(temporalAdjuster);
		LOG.info(result.toString());
		return result;

	}

	@Override
	public LocalDateTime primerDia(Integer mes, Integer anho) {
		LocalDateTime f = LocalDateTime.of(anho, mes, 01, 00, 00);
		LOG.info(f.toString());
		return f;

	}

}
