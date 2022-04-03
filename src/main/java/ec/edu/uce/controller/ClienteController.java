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
import ec.edu.uce.modelo.Vehiculo;
import ec.edu.uce.service.IClienteService;
import ec.edu.uce.service.IVehiculoService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private IClienteService clieService;
	
    @Autowired
	private IVehiculoService vehiService;


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
	// Comentario
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

    
  
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
  

	@RequestMapping("/buscar/{idCliente}")
	@GetMapping("/buscar/{idCliente}")
//	@RequestMapping(path = "/buscar/{idCliente}", method = RequestMethod.GET)
	public String obtenerUsuario(@PathVariable("idCliente") Integer idCliente, Model modelo) {

		Cliente estu = this.clieService.buscar(idCliente);
//		Cliente estu = new Cliente();
//		estu.setId(idCliente);
//		estu.setNombre("Ana");
//		estu.setApellido("Marin");

		modelo.addAttribute("estu", estu);
		return "cliente";
	}

	
    // @GetMapping("todos")
	
	// public String buscarTodos(Model modelo) {
	// 	List<Cliente> listaClientes = this.clieService.buscarTodos();
	// 	modelo.addAttribute("clientes", listaClientes);
        
	// 	return "lista";
	// }
//	Se necesitan dos paginas
	@PostMapping("/insertar22")
	public String insertarCliente2(Cliente cliente, BindingResult result, Model modelo,
			RedirectAttributes redirectAttrs) {

		this.clieService.insertar(cliente);

		return "redirect:todos";
	}

//	@PostMapping("/insertar")
//	public String insertarCliente(Cliente cliente, BindingResult result, Model modelo) {
//		
//		this.clieService.insertar(cliente);
//		
//		return "lista";
//	}

	@GetMapping("/clienteNuevo")
	// Comentario
	public String obtenerDato(Cliente cliente) {
		return "cliente_nuevo";

	}

//	Actualizar

	@GetMapping("clienteActualiza/{idCliente}")
	public String obtenerActualizar(@PathVariable("idCliente") Integer idCliente, Cliente cliente,
			Model modelo) {
		Cliente estu = this.clieService.buscar(idCliente);
		modelo.addAttribute("estu", estu);
		return "cliente_actualiza";
	}
	
	
	
	@PutMapping("actualizar/{idCliente}")
	public String actualizarCliente(@PathVariable("idCliente") Integer idCliente, Cliente cliente,
			BindingResult result, Model modelo, RedirectAttributes redirectAttrs) {
		cliente.setId(idCliente);
		this.clieService.actualizar(cliente);
//		List<Cliente> listaClientes = this.clieService.buscarTodos();
//		modelo.addAttribute("clientes", listaClientes);
		return "redirect:/clientes/todos";
	}



	@DeleteMapping("borrar/{idCliente}")
	public String eliminarCliente(@PathVariable("idCliente") Integer idCliente, Model modelo) {
		this.clieService.eliminar(idCliente);
//		List<Cliente> listaClientes = this.clieService.buscarTodos();
//		modelo.addAttribute("clientes", listaClientes);
		return "redirect:/clientes/todos";
	}

}
