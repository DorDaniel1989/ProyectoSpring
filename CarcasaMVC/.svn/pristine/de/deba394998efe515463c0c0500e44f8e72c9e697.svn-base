package net.izfe.g240.wfiguiarapida.web.controllers;

import java.util.Date;

import net.izfe.g240.wfiguiarapida.core.beans.Cuenta;
import net.izfe.g240.wfiguiarapida.core.beans.Idioma;
import net.izfe.g240.wfiguiarapida.core.beans.Perfil;
import net.izfe.g240.wfiguiarapida.core.facades.CuentasFacade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exception")
public class PruebasExcepcionesController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PruebasExcepcionesController.class);

	@Autowired
	private CuentasFacade cuentasFacade;

	@RequestMapping("/checked")
	public String crearCuentaConErrorChecked() throws IllegalAccessException {
		LOGGER.debug("Comienza la ejecucion de una transaccion con excepcion de tipo Checked");

		LOGGER.debug("Creando cuenta ...");

		Cuenta cuenta = new Cuenta();
		cuenta.setIdUsuario("prueba" + (int) Math.random() * 1000);
		cuenta.setPassword("p");
		cuenta.setApellido("probando..");
		cuenta.setEmail("prueba@email.com");
		cuenta.setFcreacion(new Date());
		cuenta.setTelefono(123458);
		cuenta.setNombre("nombre");

		Perfil perfil = new Perfil();
		perfil.setIdioma(Idioma.CASTELLANO);

		cuenta.setPerfil(perfil);
		LOGGER.debug("Cuenta con idUsuario {} creada", cuenta.getIdUsuario());

		LOGGER.debug("Comienzo de la transaccion.");
		this.cuentasFacade.crearCuentaConErrorChecked(cuenta);
		LOGGER.debug("Fin de la transaccion.");

		return null;
	}

	@RequestMapping("/unchecked")
	public String crearCuentaConErrorUnchecked() {
		LOGGER.debug("Comienza la ejecucion de una transaccion con excepcion de tipo Unchecked");

		LOGGER.debug("Creando cuenta ...");

		Cuenta cuenta = new Cuenta();
		cuenta.setIdUsuario("prueba" + (int) Math.random() * 1000);
		cuenta.setPassword("p");
		cuenta.setApellido("probando..");
		cuenta.setEmail("prueba@email.com");
		cuenta.setFcreacion(new Date());
		cuenta.setTelefono(123458);
		cuenta.setNombre("nombre");

		Perfil perfil = new Perfil();
		perfil.setIdioma(Idioma.CASTELLANO);

		cuenta.setPerfil(perfil);
		LOGGER.debug("Cuenta con idUsuario {} creada", cuenta.getIdUsuario());

		LOGGER.debug("Comienzo de la transaccion.");
		cuentasFacade.crearCuentaConErrorUnchecked(cuenta);
		LOGGER.debug("Fin de la transaccion.");

		return null;
	}

}
