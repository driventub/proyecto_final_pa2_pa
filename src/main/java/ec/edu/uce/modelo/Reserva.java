package ec.edu.uce.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "reserva")
public class Reserva {
    
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "seq_reserva")
    @SequenceGenerator(name ="seq_reserva",sequenceName="seq_reserva",allocationSize = 1)
    @Column(name = "rese_id")
    private Integer id;

    @Column(name = "rese_fecha_i", columnDefinition = "TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime fReservaIngreso;

    @Column(name = "rese_val_sub")
    private BigDecimal valorSubtotal;

    @Column(name = "rese_val_ice")
    private BigDecimal valorICE;
    
    @Column(name = "rese_val_total")
    private BigDecimal valorTotal;

    @Column(name = "rese_fecha_final", columnDefinition = "TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime fReservaFinal ;
    
    @ManyToOne
    @JoinColumn(name = "clie_id")
    private Cliente cliente;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getfReservaIngreso() {
        return fReservaIngreso;
    }

    public void setfReservaIngreso(LocalDateTime fReservaIngreso) {
        this.fReservaIngreso = fReservaIngreso;
    }

    public BigDecimal getValorSubtotal() {
        return valorSubtotal;
    }

    public void setValorSubtotal(BigDecimal valorSubtotal) {
        this.valorSubtotal = valorSubtotal;
    }

    public BigDecimal getValorICE() {
        return valorICE;
    }

    public void setValorICE(BigDecimal valorICE) {
        this.valorICE = valorICE;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getfReservaFinal() {
        return fReservaFinal;
    }

    public void setfReservaFinal(LocalDateTime fReservaFinal) {
        this.fReservaFinal = fReservaFinal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
}