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
// se deberia poner en plural
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private IClienteService estuService;
	
    @Autowired
	private IVehiculoService vehiService;


    // Actualizar
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

  
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
  

	@RequestMapping("/buscar/{idCliente}")
	@GetMapping("/buscar/{idCliente}")
//	@RequestMapping(path = "/buscar/{idCliente}", method = RequestMethod.GET)
	public String obtenerUsuario(@PathVariable("idCliente") Integer idCliente, Model modelo) {

		Cliente estu = this.estuService.buscar(idCliente);
//		Cliente estu = new Cliente();
//		estu.setId(idCliente);
//		estu.setNombre("Ana");
//		estu.setApellido("Marin");

		modelo.addAttribute("estu", estu);
		return "estudiante";
	}

	
    // @GetMapping("todos")
	
	// public String buscarTodos(Model modelo) {
	// 	List<Cliente> listaClientes = this.estuService.buscarTodos();
	// 	modelo.addAttribute("estudiantes", listaClientes);
        
	// 	return "lista";
	// }
//	Se necesitan dos paginas
	@PostMapping("/insertar")
	public String insertarCliente(Cliente estudiante, BindingResult result, Model modelo,
			RedirectAttributes redirectAttrs) {

		this.estuService.insertar(estudiante);

		return "redirect:todos";
	}

//	@PostMapping("/insertar")
//	public String insertarCliente(Cliente estudiante, BindingResult result, Model modelo) {
//		
//		this.estuService.insertar(estudiante);
//		
//		return "lista";
//	}

	@GetMapping("/estudianteNuevo")
	// Comentario
	public String obtenerDato(Cliente estudiante) {
		return "estudiante_nuevo";

	}

//	Actualizar

	@GetMapping("estudianteActualiza/{idCliente}")
	public String obtenerActualizar(@PathVariable("idCliente") Integer idCliente, Cliente estudiante,
			Model modelo) {
		Cliente estu = this.estuService.buscar(idCliente);
		modelo.addAttribute("estu", estu);
		return "estudiante_actualiza";
	}
	
	
	
	@PutMapping("actualizar/{idCliente}")
	public String actualizarCliente(@PathVariable("idCliente") Integer idCliente, Cliente estudiante,
			BindingResult result, Model modelo, RedirectAttributes redirectAttrs) {
		estudiante.setId(idCliente);
		this.estuService.actualizar(estudiante);
//		List<Cliente> listaClientes = this.estuService.buscarTodos();
//		modelo.addAttribute("estudiantes", listaClientes);
		return "redirect:/estudiantes/todos";
	}



	@DeleteMapping("borrar/{idCliente}")
	public String eliminarCliente(@PathVariable("idCliente") Integer idCliente, Model modelo) {
		this.estuService.eliminar(idCliente);
//		List<Cliente> listaClientes = this.estuService.buscarTodos();
//		modelo.addAttribute("estudiantes", listaClientes);
		return "redirect:/estudiantes/todos";
	}

}
