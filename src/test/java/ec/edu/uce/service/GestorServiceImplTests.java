package ec.edu.uce.service;

import java.time.LocalDateTime;
import java.time.Month;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Rollback(true)
@Transactional
public class GestorServiceImplTests {

    @Autowired
    private IGestorService gestorService;
    
    @Test
    void reservarVehiculoTest(){
        LocalDateTime fInicio = LocalDateTime.of(2033,Month.AUGUST,8,12,45);
        LocalDateTime fFinal = LocalDateTime.of(2034,Month.AUGUST,8,12,45);
        this.gestorService.reservarVehiculo("AEZ-334", "170897972-1", fInicio, fFinal);
    }
}
