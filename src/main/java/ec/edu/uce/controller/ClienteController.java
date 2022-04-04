package ec.edu.uce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ec.edu.uce.modelo.Cliente;
import ec.edu.uce.modelo.Reserva;
import ec.edu.uce.modelo.Vehiculo;
import ec.edu.uce.service.IClienteService;
import ec.edu.uce.service.IGestorService;
import ec.edu.uce.service.IReservaService;
import ec.edu.uce.service.IVehiculoService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private IClienteService clieService;
	
    @Autowired
	private IVehiculoService vehiService;

	@Autowired
	private IReservaService reservaService;

	@Autowired
	private IGestorService gestorService;


    // 1.a 
    @GetMapping("/vehiculoBuscar")
	
	public String obtenerVehiculo(Vehiculo vehiculo) {
		return "vehiculo_buscar";

	}

    @GetMapping("/buscarMM")
	public String buscarVehiculo(Vehiculo vehiculo, BindingResult result, Model model,
			RedirectAttributes redirectAttrs) {

		List<Vehiculo> listaVehiculo = this.vehiService.buscarMarca(vehiculo.getModelo(), vehiculo.getMarca());
        model.addAttribute("listaVehiculo", listaVehiculo);
		return "marca_modelo";
	}


    // 1.c
    @GetMapping("/registroCliente")
	
	public String registroCliente(Cliente cliente) {
		return "registro_cliente";

	}

    @GetMapping("/insertar")
	public String insertarCliente(Cliente cliente, BindingResult result, Model modelo,
			RedirectAttributes redirectAttrs) {
        cliente.setRegistro("C");
		this.clieService.insertar(cliente);

		return "prueba";
	}

	// 1.b

	@GetMapping("/vehiculoReserva")
	
	public String obtenerFechas(Reserva reserva) {
		return "reserva_fechas";

	}

	@GetMapping("/reservar")
	public String reservarVehiculo(Reserva reserva, BindingResult result, Model modelo,
			RedirectAttributes redirectAttrs) {
		
		
		List<Reserva> lReserva = this.gestorService.reservarVehiculo( reserva.getVehiculo().getPlaca(), reserva.getCliente().getCedula(), reserva.getfIngreso(), reserva.getfFinal());
		modelo.addAttribute("lReserva", lReserva);
		modelo.addAttribute("reserva", reserva);

		return "if_empty";
	}

	@GetMapping("/actualizaTarjeta")
	public String actualizaTarjeta(Reserva reserva, BindingResult result, Model modelo,
			RedirectAttributes redirectAttrs) {
		
		
		
		

		return "prueba";
	}


    
  
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
  
}
