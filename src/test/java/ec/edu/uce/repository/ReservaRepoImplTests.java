package ec.edu.uce.repository;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

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
}
