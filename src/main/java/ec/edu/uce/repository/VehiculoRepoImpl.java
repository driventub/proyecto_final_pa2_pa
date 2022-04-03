package ec.edu.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Vehiculo;

@Repository
@Transactional
public class VehiculoRepoImpl implements IVehiculoRepo{
	
	private static final Logger LOG = LoggerFactory.getLogger(VehiculoRepoImpl.class); 
	
	@PersistenceContext
	private EntityManager e;
	
	@Override
	public Vehiculo buscar(Integer id) {
		return this.e.find(Vehiculo.class, id);
	}

	@Override
	public List<Vehiculo> buscarTodos() {
		TypedQuery<Vehiculo> myTypedQuery = (TypedQuery<Vehiculo>) this.e
				.createQuery("SELECT f FROM Vehiculo f    ",Vehiculo.class);
		return myTypedQuery.getResultList();
		
	}

	@Override
	public void actualizar(Vehiculo e) {
		this.e.merge(e);
		
	}

	@Override
	public void eliminar(Integer id) {
		Vehiculo gBorrar = this.buscar(id);
		this.e.remove(gBorrar);
		
	}

	@Override
	public void insertar(Vehiculo e) {
		this.e.persist(e);
		
	}

	@Override
	public List<Vehiculo> buscarMarca(String modelo, String marca) {
		TypedQuery<Vehiculo> myTypedQuery = (TypedQuery<Vehiculo>) this.e
				.createQuery("SELECT f FROM Vehiculo f WHERE f.modelo=:modelo AND f.marca=:marca",Vehiculo.class);
		myTypedQuery.setParameter("modelo", modelo);
		myTypedQuery.setParameter("marca", marca);
		
		List<Vehiculo> l1 = myTypedQuery.getResultList();
		
		return l1;
	}

}

