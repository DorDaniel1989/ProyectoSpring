package net.izfe.g240.wfiguiarapida.core.daos.impl;

import java.util.List;
import java.util.Random;

import net.izfe.g240.wfiguiarapida.core.beans.Cuenta;
import net.izfe.g240.wfiguiarapida.core.daos.CuentaDao;

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
public class CuentaDaoImplTest {

	@Autowired
	private CuentaDao cuentaDao;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void testInsertarCuenta() {

		Random r = new Random();
		int rInt = r.nextInt();

		Cuenta cuenta = new Cuenta();
		cuenta.setIdUsuario("nuevaCuenta" + rInt);
		cuenta.setPassword("password" + rInt);
		cuenta.setEmail("email" + rInt);
		cuenta.setNombre("nombre" + rInt);
		cuenta.setApellido("apellido" + rInt);
		cuenta.setTelefono(rInt);

		this.cuentaDao.insertarCuenta(cuenta);
		int numeroCuentas = this.jdbcTemplate.queryForObject("SELECT count(*) FROM " + Tablas.CUENTA
				+ " WHERE WCTIDUSUARIO = 'nuevaCuenta" + rInt + "'", Integer.class);

		Assert.assertEquals(1, numeroCuentas);
	}

	@Test
	public void testLeerCuentas() {

		List<Cuenta> cuentas = this.cuentaDao.leerCuentas(null);

		int numeroCuentas = this.jdbcTemplate.queryForObject("SELECT count(*) FROM " + Tablas.CUENTA, Integer.class);

		Assert.assertEquals(cuentas.size(), numeroCuentas);
	}

	@Test
	public void testLeerCuenta() {

		// Crear cuenta para test
		// Tras el test la cuenta se borra de manera automatica con un rollback
		Random r = new Random();
		int rInt = r.nextInt();

		Cuenta cuentaNew = new Cuenta();
		cuentaNew.setIdUsuario("nuevaCuenta" + rInt);
		cuentaNew.setPassword("password" + rInt);
		cuentaNew.setEmail("email" + rInt);
		cuentaNew.setNombre("nombre" + rInt);
		cuentaNew.setApellido("apellido" + rInt);
		cuentaNew.setTelefono(new Integer(rInt));

		this.cuentaDao.insertarCuenta(cuentaNew);

		// Testear la lectura
		Cuenta cuenta = this.cuentaDao.leerCuenta("nuevaCuenta" + rInt);

		Assert.assertTrue(cuenta != null);
		Assert.assertTrue(cuenta.getNombre().equals("nombre" + rInt));
		Assert.assertTrue(cuenta.getApellido().equals("apellido" + rInt));
		Assert.assertTrue(cuenta.getIdUsuario().equals("nuevaCuenta" + rInt));
		Assert.assertTrue(cuenta.getEmail().equals("email" + rInt));
	}

	@Test
	public void testNumeroCuentas() {

		int cuentas = this.cuentaDao.numeroCuentas();

		int numeroCuentas = this.jdbcTemplate.queryForObject("SELECT count(*) FROM " + Tablas.CUENTA, Integer.class);

		Assert.assertEquals(cuentas, numeroCuentas);
	}

	public void setCuentaDao(CuentaDao cuentaDao) {
		this.cuentaDao = cuentaDao;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
