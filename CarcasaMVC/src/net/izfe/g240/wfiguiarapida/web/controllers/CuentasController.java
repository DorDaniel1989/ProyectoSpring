package net.izfe.g240.wfiguiarapida.web.controllers;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import net.izfe.g240.wfiframeworkizfelib.paginacion.db.PaginacionHandlerIzfe;
import net.izfe.g240.wfiguiarapida.core.beans.Cuenta;
import net.izfe.g240.wfiguiarapida.core.beans.Idioma;
import net.izfe.g240.wfiguiarapida.core.facades.CuentasFacade;
import net.izfe.g240.wfiguiarapida.core.validators.ConfirmacionPasswordValidator;
import net.izfe.g240.wfiguiarapida.core.validators.UsuarioExistenteValidator;
import net.izfe.g240.wfiguiarapida.web.beans.CuentaForm;
import net.izfe.g240.wfiguiarapida.web.controllers.CuentasController.CuentasPaginacionHandler;
import net.izfe.g240.wfiguiarapida.web.conversores.ConversorPrefijo;
import net.sf.jasperreports.engine.JREmptyDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@SessionAttributes(types = CuentasPaginacionHandler.class)
@RequestMapping("/cuentas")
@Controller
public class CuentasController {

	@Autowired
	private UsuarioExistenteValidator usuarioExistenteValidator;

	@Autowired
	private CuentasFacade cuentasFacade;

	@Autowired
	private MessageSource messageSource;
	
	@InitBinder("cuentaForm")
	public void initBinder(WebDataBinder binder) {
		
		binder.registerCustomEditor(Integer.class, "cuenta.telefono", new ConversorPrefijo());
		binder.addValidators(new ConfirmacionPasswordValidator(), usuarioExistenteValidator);
	}

	@RequestMapping("/{idUsuario}")
	public String verCuenta(@PathVariable String idUsuario, Model model) {
		Cuenta cuenta = cuentasFacade.leerCuenta(idUsuario);
		model.addAttribute(cuenta);

		return "cuentas/verCuenta";
	}

	@RequestMapping("/new")
	public String crearCuentaForm(Model model) {
		model.addAttribute(new CuentaForm());

		return "cuentas/nuevaCuenta";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String crearCuenta(@Validated @ModelAttribute CuentaForm cuentaForm, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, SessionStatus sessionStatus) { 

		if (bindingResult.hasErrors()) {
			return "cuentas/nuevaCuenta";
		}

		cuentasFacade.crearCuenta(cuentaForm.getCuenta());
       
		sessionStatus.setComplete();
		redirectAttributes.addFlashAttribute("successMessage", "cuentaCreadaMessage");

		return "redirect:/cuentas";
	}

	@ModelAttribute("idiomas")
	public Idioma[] getIdiomas() {
		return Idioma.values();
	}

	@RequestMapping()
	public String listado(Model model) {
		PaginacionHandlerIzfe paginacionHandler = new CuentasPaginacionHandler();
		List<Cuenta> cuentas = this.cuentasFacade.leerCuentas(paginacionHandler);
		paginacionHandler.actualizarPaginacion(cuentas);

		model.addAttribute(cuentas);
		model.addAttribute(paginacionHandler);

		return "cuentas/listadoCuentas";
	}

	@RequestMapping(params = { "page" })
	public String soloTabla(@RequestParam int page, @ModelAttribute CuentasPaginacionHandler paginacionHandler,
			Model model) {

		paginacionHandler.irPaginaIndice(page);

		List<Cuenta> cuentas = this.cuentasFacade.leerCuentas(paginacionHandler);
		paginacionHandler.actualizarPaginacion(cuentas);

		model.addAttribute(cuentas);
		model.addAttribute(paginacionHandler);

		return "cuentas/listadoCuentas";
	}

	@RequestMapping("/pdf")
	public String crearInformePdf(Locale locale, Model model) {
		List<Cuenta> listaCuentas = this.cuentasFacade.leerCuentas(null);

		model.addAttribute("datasource", listaCuentas);
		model.addAttribute("fecha", new Date());
		model.addAttribute("DATE_PATTERN", this.messageSource.getMessage("format.date.short", null, locale));
		model.addAttribute("SUBREPORT_DATASOURCE", new JREmptyDataSource());

		return "pdfReport";
	}

	public static class CuentasPaginacionHandler extends PaginacionHandlerIzfe {

		private static final long serialVersionUID = 1L;

		public CuentasPaginacionHandler() {
			setTamanoPagina(10);
			setCriterio("idUsuario", PaginacionHandlerIzfe.ORDEN_ASCENDENTE);
			irPaginaPrimera();
		}
	}

}
