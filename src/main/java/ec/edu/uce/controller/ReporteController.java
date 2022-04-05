package ec.edu.uce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import ec.edu.uce.modelo.ReporteClientesVIP;
import ec.edu.uce.modelo.ReporteVehiculoVIP;
import ec.edu.uce.modelo.Reserva;
import ec.edu.uce.service.IReservaService;

@Controller
@RequestMapping("/reportes")
public class ReporteController {
        
	
    
	@Autowired
	private IReservaService reserService;

	

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

	// 3.d
	@GetMapping("/vehiculosVIP")
	public String obtenerMes( Model model) {
		return "reporte_mes";

	}


	// ver la pagina como /?mes=1_____
	@GetMapping("/buscarVehiVIP")
	public String reporteVehiculosVIP( @RequestParam("mes") String mes ,@RequestParam("anho") String anho, BindingResult result, Model modelo,
			RedirectAttributes redirectAttrs) {
		Integer m = Integer.valueOf(mes);
		Integer a = Integer.valueOf(anho);
		
		List<ReporteVehiculoVIP> vehi = this.reserService.reportarVehiculo(m, a);
		modelo.addAttribute("vehi", vehi);
		

		return "reporte_vehi_vip";
	}


}
