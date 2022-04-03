package ec.edu.uce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Vehiculo;
import ec.edu.uce.repository.IVehiculoRepo;

@Service
public class VehiculoServiceImpl implements IVehiculoService {
	
	@Autowired
	private IVehiculoRepo estu;
	
	@Override
	public Vehiculo buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.estu.buscar(id);
	}

	@Override
	public List<Vehiculo> buscarTodos() {
		// TODO Auto-generated method stub
		return this.estu.buscarTodos();
	}

	@Override
	public void actualizar(Vehiculo e) {
		this.estu.actualizar(e);
		
	}

	@Override
	public void eliminar(Integer id) {
		this.estu.eliminar(id);
		
	}

	@Override
	public void insertar(Vehiculo e) {
		this.estu.insertar(e);
		
	}

    @Override
    public List<Vehiculo> buscarMarca(String modelo, String marca) {
        // TODO Auto-generated method stub
        return this.estu.buscarMarca(modelo, marca);
    }

}
