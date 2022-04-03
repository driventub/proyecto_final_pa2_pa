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

@Entity
@Table(name = "vehiculo")
public class Vehiculo {
    
    @Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "seq_vehi")
	@SequenceGenerator(name ="seq_vehi",sequenceName="seq_vehi",allocationSize = 1)
	@Column(name = "vehi_id")
    private Integer id;


    @Column(name = "vehi_placa")
    private String placa;

    @Column(name = "vehi_modelo")
    private String modelo;

    @Column(name = "vehi_marca")
    private String marca;

    @Column(name = "vehi_anho")
    private String anho;

    @Column(name = "vehi_cilind")
    private BigDecimal cilindraje;

    @Column(name = "vehi_avaluo")
    private BigDecimal avaluo ;

    @Column(name = "vehi_estado")
    private String estado;

    @Column(name = "vehi_valor")
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "clie_id")
    private Cliente cliente;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public BigDecimal getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(BigDecimal cilindraje) {
        this.cilindraje = cilindraje;
    }

    public BigDecimal getAvaluo() {
        return avaluo;
    }

    public void setAvaluo(BigDecimal avaluo) {
        this.avaluo = avaluo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
}
