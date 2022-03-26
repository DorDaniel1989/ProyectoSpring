package net.izfe.g240.wfiguiarapida.web.rest;

import java.util.List;

import net.izfe.g240.wfiguiarapida.core.beans.Cuenta;
import net.izfe.g240.wfiguiarapida.core.facades.CuentasFacade;
import net.izfe.g240.wfiguiarapida.web.beans.CuentasWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/api/cuentas")
public class RestCuentaController {

	@Autowired
	private CuentasFacade cuentasFacade;

	@RequestMapping(value = "{id}", produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public Cuenta getById(@PathVariable String id) {
		return cuentasFacade.leerCuenta(id);
	}

	@RequestMapping(produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public CuentasWrapper all() {
		List<Cuenta> cuentas= cuentasFacade.leerCuentas(null);
		CuentasWrapper wrapper = new CuentasWrapper(cuentas);
		return wrapper;
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void guardarCuentas(@RequestBody CuentasWrapper cuentasWrapper) {
		for (Cuenta cuenta : cuentasWrapper.getCuentas()) {
			cuentasFacade.crearCuenta(cuenta);
		}
	}
}
