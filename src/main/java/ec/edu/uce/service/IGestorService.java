package ec.edu.uce.service;

import java.time.LocalDateTime;
import java.util.List;

import ec.edu.uce.modelo.Reserva;

public interface IGestorService {
    public List<Reserva> reservarVehiculo(String placa, String cedula, LocalDateTime fInicio, LocalDateTime fFinal);
    public Reserva retirarReservado(String numero);
    public String numeroReservaAleatorio();
}
