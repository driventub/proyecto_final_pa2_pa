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
    private LocalDateTime fIngreso;

    @Column(name = "rese_val_sub")
    private BigDecimal valorSubtotal;

    @Column(name = "rese_val_ice")
    private BigDecimal valorICE;
    
    @Column(name = "rese_val_total")
    private BigDecimal valorTotal;

    @Column(name = "rese_fecha_final", columnDefinition = "TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime fFinal ;

    @Column(name = "rese_estado")
    private String estado;

    @Column(name = "rese_numero")
    private String numero;
    
    @ManyToOne
    @JoinColumn(name = "clie_id")
    private Cliente cliente;

    
    @ManyToOne
    @JoinColumn(name = "vehi_id")
    private Vehiculo vehiculo;

// Set y Get
    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public LocalDateTime getfIngreso() {
        return fIngreso;
    }


    public void setfIngreso(LocalDateTime fIngreso) {
        this.fIngreso = fIngreso;
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


    public LocalDateTime getfFinal() {
        return fFinal;
    }


    public void setfFinal(LocalDateTime fFinal) {
        this.fFinal = fFinal;
    }


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }


    public Cliente getCliente() {
        return cliente;
    }


    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public Vehiculo getVehiculo() {
        return vehiculo;
    }


    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }


    public String getNumero() {
        return numero;
    }


    public void setNumero(String numero) {
        this.numero = numero;
    }


    @Override
    public String toString() {
        return "Reserva [cliente=" + cliente + ", estado=" + estado + ", fFinal=" + fFinal + ", fIngreso=" + fIngreso
                + ", id=" + id + ", numero=" + numero + ", valorICE=" + valorICE + ", valorSubtotal=" + valorSubtotal
                + ", valorTotal=" + valorTotal + ", vehiculo=" + vehiculo + "]";
    }
    
    

    
    
}