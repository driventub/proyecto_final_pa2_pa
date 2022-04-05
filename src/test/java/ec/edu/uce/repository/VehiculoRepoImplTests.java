package ec.edu.uce.repository;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Rollback(true)
@Transactional
public class VehiculoRepoImplTests {
    
    
    @Autowired
    private IVehiculoRepo vehiculoRepo;

    @Test
    void testBuscarMarca() {
        this.vehiculoRepo.buscarMarca("Prius", "Toyota");
    }
}
