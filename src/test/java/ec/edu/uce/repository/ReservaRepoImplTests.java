package ec.edu.uce.repository;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import ec.edu.uce.modelo.Reserva;

@SpringBootTest
@Rollback(true)
@Transactional
public class ReservaRepoImplTests {
    @Autowired
    private IReservaRepo repo;

    @Test
    void clienteReporte(){
        this.repo.reportarCliente();
    }
    @Test
    void vehiculoReporte(){
       
        this.repo.reportarVehiculo(4, 2022);
    }
    @Test
    void testUltimoDia() {
        this.repo.ultimoDia(4, 2022);
    }
    @Test
    void testBuscarNum() {
        this.repo.buscarNum("biR87qjAPk");
    }
    @Test
    void testActualizar() {
        Reserva r = this.repo.buscar(1);
        r.setEstado("E");
        this.repo.actualizar(r);
    }
    @Test
    void testBuscar() {
        this.repo.buscar(1);
    }
    @Test
    void testEliminar() {
        this.repo.eliminar(1);
    }
    @Test
    void testInsertar() {
        Reserva r = new Reserva();
        r.setEstado("G");
        this.repo.insertar(r);
    }
}
