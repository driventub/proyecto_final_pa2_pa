package ec.edu.uce.repository;

import java.util.List;

import ec.edu.uce.modelo.Cliente;

public interface IClienteRepo {
	public Cliente buscar(Integer id);
	public List<Cliente> buscarTodos();
	public void actualizar(Cliente e);
	public void eliminar(Integer id);
	public void insertar(Cliente e);
}