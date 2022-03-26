package net.izfe.g240.wfiguiarapida.core.facades.impl;

import java.util.Date;
import java.util.List;

import net.izfe.g240.wfiframeworkizfelib.paginacion.db.PaginacionHandlerIzfe;
import net.izfe.g240.wfiguiarapida.core.beans.Cuenta;
import net.izfe.g240.wfiguiarapida.core.daos.CuentaDao;
import net.izfe.g240.wfiguiarapida.core.daos.PerfilDao;
import net.izfe.g240.wfiguiarapida.core.facades.CuentasFacade;
import net.izfe.g240.wfiguiarapidalib.core.beans.Log;
import net.izfe.g240.wfiguiarapidalib.core.facades.LogsFacade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CuentasFacadeImpl implements CuentasFacade {

	private static final Logger LOGGER = LoggerFactory.getLogger(CuentasFacadeImpl.class);

	@Autowired
	private CuentaDao cuentaDao;

	@Autowired
	private PerfilDao perfilDao;
	
	@Autowired
	private LogsFacade logsFacade;

	/**
	 * Inserta una nueva cuenta de usuario en la base de datos con la informacion de <code>cuenta</code>. Ademas inserta
	 * el nuevo perfil para el mismo identificador de usuario.
	 * 
	 * @param cuenta
	 *            Nueva cuenta de usuario
	 */
	@Transactional
	public void crearCuenta(Cuenta cuenta) {
		this.cuentaDao.insertarCuenta(cuenta);
		int idPerfil = this.perfilDao.obtenerSiguienteId();

		cuenta.getPerfil().setCuenta(cuenta);
		cuenta.getPerfil().setIdPerfil(idPerfil);

		this.perfilDao.insertarPerfil(cuenta.getPerfil());
		
		crearLog();
		
		LOGGER.info("Cuenta creada");
	}
	
	protected void crearLog() {
		Log log = new Log();
		log.setAplic("WFIGuiaRapidaWEB");
		log.setDatos("DATOS PRUEBA");
		log.setDirip("127.0.0.1");
		log.setIdusu("USER");
		log.setServ("SERV");
		log.setTimes(new Date());
		log.setTipref((short)1);
		logsFacade.crearLog(log);
	}

	/**
	 * @return Devuelve todas las cuentas de usuario.
	 */
	public List<Cuenta> leerCuentas(PaginacionHandlerIzfe paginacionHandler) {
		return this.cuentaDao.leerCuentas(paginacionHandler);
	}

	public int numeroCuentas() {
		return this.cuentaDao.numeroCuentas();
	}

	public Cuenta leerCuenta(String idUsuario) {
		return this.cuentaDao.leerCuenta(idUsuario);
	}

	@Transactional
	public void crearCuentaConErrorUnchecked(Cuenta cuenta) {
		this.cuentaDao.insertarCuenta(cuenta);
		int idPerfil = this.perfilDao.obtenerSiguienteId();

		if ("".equals("")) {
			throw new RuntimeException("Error en la transaccion");
		}

		cuenta.getPerfil().setCuenta(cuenta);
		cuenta.getPerfil().setIdPerfil(idPerfil);

		this.perfilDao.insertarPerfil(cuenta.getPerfil());

		LOGGER.info("Cuenta creada");
	}

	@Transactional(rollbackFor = IllegalAccessException.class)
	public void crearCuentaConErrorChecked(Cuenta cuenta) throws IllegalAccessException {
		this.cuentaDao.insertarCuenta(cuenta);
		int idPerfil = this.perfilDao.obtenerSiguienteId();

		if ("".equals("")) {
			throw new IllegalAccessException("Error en la transaccion");
		}
		cuenta.getPerfil().setCuenta(cuenta);
		cuenta.getPerfil().setIdPerfil(idPerfil);

		this.perfilDao.insertarPerfil(cuenta.getPerfil());

		LOGGER.info("Cuenta creada");
	}

}
