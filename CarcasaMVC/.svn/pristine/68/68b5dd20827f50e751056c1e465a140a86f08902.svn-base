package net.izfe.g240.wfiguiarapida.web.controllers;

import javax.servlet.http.HttpServletRequest;

import net.izfe.g240.wfiguiarapida.core.beans.Cuenta;
import net.izfe.g240.wfiguiarapida.core.beans.Idioma;
import net.izfe.g240.wfiguiarapida.core.beans.Perfil;
import net.izfe.g240.wfiguiarapida.core.facades.CuentasFacade;
import net.izfe.g240.wfiguiarapida.core.validators.CuentasWizardValidations.DatosUsuario;
import net.izfe.g240.wfiguiarapida.core.validators.CuentasWizardValidations.InformacionCuenta;
import net.izfe.g240.wfiguiarapida.core.validators.CuentasWizardValidations.InformacionPerfil;
import net.izfe.g240.wfiguiarapida.core.validators.UsuarioWizardExistenteValidator;
import net.izfe.g240.wfiguiarapida.web.beans.CuentaWizard;
import net.izfe.g240.wfiguiarapida.web.conversores.ConversorPrefijo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@SessionAttributes(types = CuentaWizard.class)
@RequestMapping("/cuentas")
@Controller
public class CuentasWizardController {
	
	@Autowired 
	private UsuarioWizardExistenteValidator usuarioWizardExistenteValidator;
	
	@Autowired 
	private CuentasFacade cuentasFacade;

	@InitBinder
	public void initBinder(DataBinder dataBinder, HttpServletRequest request) {
		dataBinder.registerCustomEditor(Integer.class, "cuenta.telefono", new ConversorPrefijo());
		
		if (request.getRequestURI().endsWith("/new/datosUsuario")) {
			dataBinder.addValidators(usuarioWizardExistenteValidator);
		}
	}
	
	@RequestMapping("/new/init")
	public String init(Model model) {
		model.addAttribute(new CuentaWizard());
		return "cuentas/wizard/informacionCuenta";
	}
	
	@RequestMapping("/new/informacionCuenta")
	public String informacionCuenta(Model model) {
		return "cuentas/wizard/informacionCuenta";
	}
	
	@RequestMapping(value = "/new/informacionCuenta", method = RequestMethod.POST)
	public String informacionCuenta(@Validated(InformacionCuenta.class) @ModelAttribute CuentaWizard cuentaWizard, 
			BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			return "cuentas/wizard/informacionCuenta";
		}
		
		return "redirect:/cuentas/new/datosUsuario";
	}
	
	@RequestMapping("/new/datosUsuario")
	public String datosUsuario(Model model) {
		return "cuentas/wizard/datosUsuario";
	}
	
	@RequestMapping(value = "/new/datosUsuario", method = RequestMethod.POST)
	public String datosUsuario(@Validated(DatosUsuario.class) @ModelAttribute CuentaWizard cuentaWizard, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			return "cuentas/wizard/datosUsuario";
		}
		
		return "redirect:/cuentas/new/informacionPerfil";
	}
	
	@RequestMapping("/new/informacionPerfil")
	public String informacionPerfil(Model model) {
		model.addAttribute("idiomas", Idioma.values());
		return "cuentas/wizard/informacionPerfil";
	}
	
	@RequestMapping(value = "/new/informacionPerfil", method = RequestMethod.POST)
	public String informacionPerfil(@Validated(InformacionPerfil.class) @ModelAttribute CuentaWizard cuentaWizard, BindingResult bindingResult, 
			RedirectAttributes redirectAttributes, SessionStatus sessionStatus) {
		
		if (bindingResult.hasErrors()) {
			redirectAttributes.addAttribute("idiomas", Idioma.values());
			return "cuentas/wizard/informacionPerfil";
		}
		
		cuentasFacade.crearCuenta(convertToCuenta(cuentaWizard));
		
		sessionStatus.setComplete();
		redirectAttributes.addFlashAttribute("successMessage", "cuentaCreadaMessage");
		
		return "redirect:/cuentas";
	}
	
	/**
	 * Como no reutilizan el dao y facade del bean cuenta, se convierte el bean CuentaWizard en Cuenta
	 */
	private static Cuenta convertToCuenta(CuentaWizard cuentaWizard) {
		Cuenta cuenta = new Cuenta();
		
		cuenta.setApellido(cuentaWizard.getApellido());
		cuenta.setEmail(cuentaWizard.getEmail());
		cuenta.setFcreacion(cuentaWizard.getFcreacion());
		cuenta.setIdUsuario(cuentaWizard.getIdUsuario());
		cuenta.setNombre(cuentaWizard.getNombre());
		cuenta.setTelefono(cuentaWizard.getTelefono());
		
		cuenta.setPassword(cuentaWizard.getPassword());
		
		/*
		 * El formulario de tipo wizard de la guía rápida no tiene la opción de seleccionar
		 * el idioma y por eso todas las cuentas creadas con el wizard llevan el idioma inglés
		 */
		Perfil perfil = new Perfil();
		perfil.setIdioma(Idioma.INGLES);
		cuenta.setPerfil(perfil);
		
		return cuenta;
	}
	
}
