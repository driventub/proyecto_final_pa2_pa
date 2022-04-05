package ec.edu.uce.service;



import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

import java.time.LocalDateTime;
import java.time.Month;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.annotation.Rollback;

import ec.edu.uce.modelo.Reserva;

@SpringBootTest
@Rollback(true)
@Transactional
public class GestorServiceImplTests {

    @Autowired
    private IGestorService gestorService;

    @Autowired
    private IReservaService reserva;
    
    @Test
    void reservarVehiculoTest(){
        LocalDateTime fInicio = LocalDateTime.of(2033,Month.AUGUST,8,12,45);
        LocalDateTime fFinal = LocalDateTime.of(2034,Month.AUGUST,8,12,45);
        this.gestorService.reservarVehiculo("AEZ-334", "170897972-1", fInicio, fFinal);
    }

  

    @Test
    void testRetirarReservado() {
        this.gestorService.retirarReservado("biR87qjAPk");
    }

    @Test
    void  nombreReserva(){
        String c = this.gestorService.numeroReservaAleatorio();
        try{
            Reserva r = this.reserva.buscarNum(c);
            assertThat(c, not(r.getNumero()));
        }catch(EmptyResultDataAccessException e){
            Reserva re = null;
        }
        
        

        
    }
}
