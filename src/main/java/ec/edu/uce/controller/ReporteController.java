package ec.edu.uce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ec.edu.uce.modelo.ReporteClientesVIP;
import ec.edu.uce.modelo.Reserva;
import ec.edu.uce.service.IClienteService;
import ec.edu.uce.service.IGestorService;
import ec.edu.uce.service.IReservaService;
import ec.edu.uce.service.IVehiculoService;

@Controller
@RequestMapping("/reportes")
public class ReporteController {
        
	@Autowired
	private IClienteService clieService;
	
    @Autowired
	private IVehiculoService vehiService;
    
	@Autowired
	private IReservaService reserService;

	@Autowired
	private IGestorService gestorService;

	// 3.a

    @GetMapping("/buscaReporte")
	
	public String obtenerFechas(Reserva reserva) {
		return "reporte_fechas";

	}

    @GetMapping("/reporteReserva")
	public String reservarVehiculo(Reserva reserva, BindingResult result, Model modelo,
			RedirectAttributes redirectAttrs) {
		
		
		List<Reserva> lReserva = this.reserService.reporteReserva( reserva.getfIngreso(), reserva.getfFinal());
		modelo.addAttribute("lReserva", lReserva);
		

		return "reporte_rese_todo";
	}

	// 3.c
	@GetMapping("/clientesVIP")
	public String reporteClientesVIP(ReporteClientesVIP reporte, BindingResult result, Model modelo,
			RedirectAttributes redirectAttrs) {
		
		
		List<ReporteClientesVIP> clie = this.reserService.reportarCliente();
		modelo.addAttribute("clie", clie);
		

		return "reporte_clie_vip";
	}


}
