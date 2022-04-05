package ec.edu.uce.repository;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import ec.edu.uce.modelo.Cliente;

@SpringBootTest
@Rollback(true)
@Transactional
public class ClienteRepoImplTests {
    @Autowired
    private IClienteRepo cli;
    
    @Test
    void testBuscarCedula() {
        this.cli.buscarCedula("170897972-1");
    }

    @Test
    void testInsertar() {
        Cliente e = new Cliente();
        e.setCedula("131212134-3");
        e.setApellido("Suarez");
        this.cli.insertar(e);
        

    }
}
