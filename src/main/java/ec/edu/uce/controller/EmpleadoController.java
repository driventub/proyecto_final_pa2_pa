package ec.edu.uce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ec.edu.uce.modelo.Cliente;
import ec.edu.uce.modelo.Vehiculo;
import ec.edu.uce.service.IClienteService;
import ec.edu.uce.service.IVehiculoService;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {
    
	@Autowired
	private IClienteService clieService;
	
    @Autowired
	private IVehiculoService vehiService;


    // 2.a

    @GetMapping("/registroCliente")
	
	public String registroCliente(Cliente cliente) {
		return "reg_clie_empleado";

	}

    @GetMapping("/insertarCliente")
	public String insertarCliente(Cliente cliente, BindingResult result, Model modelo,
			RedirectAttributes redirectAttrs) {
        cliente.setRegistro("E");
		this.clieService.insertar(cliente);

		return "prueba";
	}

	// 2.b
	@GetMapping("/clienteBuscar")
	
	public String obtenerCliente(Cliente cliente) {
		return "cedula_buscar";

	}

    @GetMapping("/buscarCliente")
	public String buscarCliente(Cliente cliente, BindingResult result, Model model,
			RedirectAttributes redirectAttrs) {

		Cliente cli = this.clieService.buscarCedula(cliente.getCedula());
        model.addAttribute("cli", cli);
		return "cedula_todo";
	}

	// 2.c

	 @GetMapping("/registroVehiculo")
	
	public String registroVehiculo(Vehiculo cliente) {
		return "reg_vehiculo";

	}

    @GetMapping("/insertarVehiculo")
	public String insertarVehiculo(Vehiculo cliente, BindingResult result, Model modelo,
			RedirectAttributes redirectAttrs) {
        
		this.vehiService.insertar(cliente);

		return "prueba";
	}
    
	// 2.d 

	
	@GetMapping("/vehiculoBuscar")
	
	public String obtenerVehiculo(Vehiculo vehi) {
		return "placa_buscar";

	}

    @GetMapping("/buscarVehiculo")
	public String buscarVehiculo(Vehiculo vehi, BindingResult result, Model model,
			RedirectAttributes redirectAttrs) {

		Vehiculo vehiculo = this.vehiService.buscarPlaca(vehi.getPlaca());
        model.addAttribute("vehiculo", vehiculo);
		return "placa_todo";
	}

}
