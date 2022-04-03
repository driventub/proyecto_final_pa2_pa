package ec.edu.uce.modelo;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "cliente")
public class Cliente {
    
    @Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "seq_clie")
	@SequenceGenerator(name ="seq_clie",sequenceName="seq_clie",allocationSize = 1)
	@Column(name = "clie_id")
    private Integer id;

    @Column(name = "clie_cedula")
    private String cedula;

    @Column(name = "clie_nombre")
    private String nombre;

    @Column(name = "clie_apellido")
    private String apellido;

    @Column(name = "clie_fecha_naci", columnDefinition = "TIMESTAMP")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime fechaNaci;
    
    @Column(name = "clie_genero")
    private String genero;

    @Column(name = "clie_registro")
    private String registro;

    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL )
    private List<Reserva> reserva;
    
    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL )
    private List<Vehiculo> vehiculo;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDateTime getFechaNaci() {
        return fechaNaci;
    }

    public void setFechaNaci(LocalDateTime fechaNaci) {
        this.fechaNaci = fechaNaci;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public List<Reserva> getReserva() {
        return reserva;
    }

    public void setReserva(List<Reserva> reserva) {
        this.reserva = reserva;
    }

    public List<Vehiculo> getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(List<Vehiculo> vehiculo) {
        this.vehiculo = vehiculo;
    }

    
    

}