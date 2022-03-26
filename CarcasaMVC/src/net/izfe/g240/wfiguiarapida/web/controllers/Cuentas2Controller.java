package net.izfe.g240.wfiguiarapida.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.izfe.g240.wfiguiarapida.core.beans.Usuario2;
import net.izfe.g240.wfiguiarapida.core.facades.CuentasFacade2;
import net.izfe.g240.wfiguiarapida.web.beans.CuentaForm;


@RequestMapping("/cuentas2")
@Controller
public class Cuentas2Controller {
	
	private Usuario2 user ;
	@Autowired
	private CuentasFacade2 cuentasFacade2;
	
	@RequestMapping()
	public String listado(Model model) {
	//	PaginacionHandlerIzfe paginacionHandler = new CuentasPaginacionHandler();
		List<Usuario2> cuentas = this.cuentasFacade2.leerUsuarios();
		//paginacionHandler.actualizarPaginacion(cuentas);

		model.addAttribute("cuentasUsuario", cuentas);
		//model.addAttribute(paginacionHandler);

		return "cuentas/listadoUsuarios";
	}
	
	@RequestMapping( path = "/newUsuario", method = RequestMethod.GET )
	public String crearUsuario(Model model) {
    
		model.addAttribute("usuario", new Usuario2());
		
		return "cuentas/nuevoUsuario";
	}
	@RequestMapping( path = "/newUsuario", method = RequestMethod.POST )
	public String guardarUsuario(Model model ,@ModelAttribute("usuario") Usuario2 user) {
    
		cuentasFacade2.nuevoUsuario(user);
		
		return "cuentas/nuevoUsuario";
	}

}
