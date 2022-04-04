package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Cliente;
import ec.edu.uce.modelo.Reserva;
import ec.edu.uce.modelo.Vehiculo;

@Service
public class GestorServiceImpl implements IGestorService{

    private static final Logger LOG = LoggerFactory.getLogger(GestorServiceImpl.class);

    @Autowired
    private IReservaService reservaService;

    @Autowired
    private IVehiculoService vehiculoService;

    @Autowired
    private IClienteService clienteService;

    @Override
    @Transactional
    public List<Reserva> reservarVehiculo(String placa, String cedula, LocalDateTime fInicio, LocalDateTime fFinal) {

        List<Reserva> lReserva = this.reservaService.buscarPorFechas(fInicio, fFinal, placa);
        if (lReserva.isEmpty()) {
            Vehiculo vehiculo = this.vehiculoService.buscarPlaca(placa);
            Reserva reservaNueva = new Reserva();
            Cliente cliente = this.clienteService.buscarCedula(cedula);
            
            reservaNueva.setEstado("G");
            long contarDias =  ChronoUnit.DAYS.between(fInicio, fFinal);
            String dias = Long.toString(contarDias);
            LOG.info(dias);
            BigDecimal valorSubtotal = vehiculo.getValor().multiply(new BigDecimal(dias));
            BigDecimal valorICE = valorSubtotal.multiply(new BigDecimal("0.15"));
            BigDecimal valorTotal = valorICE.add(valorSubtotal);
            // BigDecimal valorICE = 
            String numAleatorio = numeroReservaAleatorio();
            LOG.info(numAleatorio);
            reservaNueva.setfIngreso(fInicio);
            reservaNueva.setfFinal(fFinal);
            reservaNueva.setNumero(numAleatorio);
            reservaNueva.setValorSubtotal(valorSubtotal);
            reservaNueva.setValorICE(valorICE);
            reservaNueva.setValorTotal(valorTotal);
            reservaNueva.setCliente(cliente);
            reservaNueva.setVehiculo(vehiculo);
            
            this.reservaService.insertar(reservaNueva);

        }else{
            LOG.info("Ya se encuentra reservado en las fechas solicitadas");
        }

        return lReserva;
    }

        public String numeroReservaAleatorio() {
            int leftLimit = 48; // numeral '0'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = 10;
            Random random = new Random();
        
            String generatedString = random.ints(leftLimit, rightLimit + 1)
              .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
              .limit(targetStringLength)
              .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
              .toString();
        
            System.out.println(generatedString);
        
            return generatedString;
        
    }

        @Override
        @Transactional
        public Reserva retirarReservado(String numero) {
            Reserva r = this.reservaService.buscarNum(numero);
            Vehiculo v = this.vehiculoService.buscarPlaca(r.getVehiculo().getPlaca());
            r.setEstado("E");
            v.setEstado("I");
            this.vehiculoService.actualizar(v);
            this.reservaService.actualizar(r);
            return r;
        }
    
}
