package ec.edu.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Cliente;

@Repository
@Transactional
public class ClienteRepoImpl implements IClienteRepo{
	
	private static final Logger LOG = LoggerFactory.getLogger(ClienteRepoImpl.class); 
	
	@PersistenceContext
	private EntityManager e;
	
	@Override
	public Cliente buscar(Integer id) {
		return this.e.find(Cliente.class, id);
	}

	@Override
	public List<Cliente> buscarTodos() {
		TypedQuery<Cliente> myTypedQuery = (TypedQuery<Cliente>) this.e
				.createQuery("SELECT f FROM Cliente f    ",Cliente.class);
		return myTypedQuery.getResultList();
		
	}

	@Override
	public void actualizar(Cliente e) {
		this.e.merge(e);
		
	}

	@Override
	public void eliminar(Integer id) {
		Cliente gBorrar = this.buscar(id);
		this.e.remove(gBorrar);
		
	}

	@Override
	public void insertar(Cliente e) {
		this.e.persist(e);
		
	}

	@Override
	public Cliente buscarCedula(String cedula) {

		
		TypedQuery<Cliente> myTypedQuery = (TypedQuery<Cliente>) this.e
				.createQuery("SELECT f FROM Cliente f WHERE f.cedula=:cedula",Cliente.class);
		myTypedQuery.setParameter("cedula", cedula);
		
		return myTypedQuery.getSingleResult();
	}

}
