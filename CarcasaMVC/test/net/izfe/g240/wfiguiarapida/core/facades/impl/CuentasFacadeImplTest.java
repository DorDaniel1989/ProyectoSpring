package net.izfe.g240.wfiguiarapida.core.facades.impl;

import java.util.List;
import java.util.Random;

import net.izfe.g240.wfiframeworkizfelib.paginacion.db.PaginacionHandlerIzfe;
import net.izfe.g240.wfiguiarapida.core.beans.Cuenta;
import net.izfe.g240.wfiguiarapida.core.beans.Idioma;
import net.izfe.g240.wfiguiarapida.core.beans.Perfil;
import net.izfe.g240.wfiguiarapida.core.daos.impl.Tablas;
import net.izfe.g240.wfiguiarapida.core.facades.CuentasFacade;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/net/izfe/g240/wfiguiarapida/core/config/applicationContext.xml",
		"classpath:/net/izfe/g240/wfiguiarapida/core/config/applicationContext-test.xml" })
@Transactional
public class CuentasFacadeImplTest {

	@Autowired
	private CuentasFacade gestionCuentasFacade;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void testCrearCuenta() {

		Random r = new Random();
		int rInt = r.nextInt();

		Cuenta cuenta = new Cuenta();
		cuenta.setIdUsuario("nuevaCuenta" + rInt);
		cuenta.setPassword("password" + rInt);
		cuenta.setEmail("email" + rInt);
		cuenta.setNombre("nombre" + rInt);
		cuenta.setApellido("apellido" + rInt);
		cuenta.setTelefono(rInt);

		Perfil perfil = new Perfil();
		perfil.setCuenta(cuenta);
		perfil.setIdPerfil(rInt);
		perfil.setIdioma(Idioma.EUSKERA);

		cuenta.setPerfil(perfil);

		// Emular la existendia de un usuario demo
		this.gestionCuentasFacade.crearCuenta(cuenta);
		int numeroCuentas = this.jdbcTemplate.queryForObject("SELECT count(*) FROM " + Tablas.CUENTA
				+ " WHERE WCTIDUSUARIO='nuevaCuenta" + rInt + "'", Integer.class);
		int numeroPerfiles = this.jdbcTemplate.queryForObject("SELECT count(*) FROM " + Tablas.PERFIL
				+ " WHERE WPRIDUSUARIO='nuevaCuenta" + rInt + "'", Integer.class);

		Assert.assertEquals(numeroCuentas, 1);
		Assert.assertEquals(numeroPerfiles, 1);

	}

	@Test
	public void testLeerCuenta() {
		Cuenta cuenta = this.gestionCuentasFacade.leerCuenta("usuario 1");

		Assert.assertEquals(cuenta.getApellido(), "Zubiaurre Mendia");
	}

	@Test
	public void testLeerCuentas() {
		List<Cuenta> cuentas = this.gestionCuentasFacade.leerCuentas(null);

		int numeroCuentas = this.jdbcTemplate.queryForObject("SELECT count(*) FROM " + Tablas.CUENTA, Integer.class);
		Assert.assertEquals(cuentas.size(), numeroCuentas);
	}

	@Test
	public void testLeerCuentasPaginado() {
		PaginacionHandlerIzfe paginacionHandler = new PaginacionHandlerIzfe();
		paginacionHandler.setTamanoPagina(2);
		paginacionHandler.setCriterio("idUsuario", PaginacionHandlerIzfe.ORDEN_ASCENDENTE);

		List<Cuenta> cuentas = this.gestionCuentasFacade.leerCuentas(paginacionHandler);
		Assert.assertEquals(cuentas.size(), 3);

		paginacionHandler.actualizarPaginacion(cuentas);
		Assert.assertEquals(cuentas.size(), 2);
	}

	public void setGestionCuentasFacade(CuentasFacade gestionCuentasFacade) {
		this.gestionCuentasFacade = gestionCuentasFacade;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
