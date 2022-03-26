package net.izfe.g240.wfiguiarapida.core.daos.impl;

import net.izfe.g240.wfiguiarapida.core.beans.Cuenta;
import net.izfe.g240.wfiguiarapida.core.beans.Idioma;
import net.izfe.g240.wfiguiarapida.core.beans.Perfil;
import net.izfe.g240.wfiguiarapida.core.daos.PerfilDao;

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
public class PerfilDaoImplTest {

	@Autowired
	private PerfilDao perfilDao;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void testInsertarPerfil() {
		Cuenta cuenta = new Cuenta();
		cuenta.setIdUsuario("demo");
		
		Perfil perfil = new Perfil();
		perfil.setCuenta(cuenta);
		perfil.setIdPerfil(999);
		perfil.setIdioma(Idioma.EUSKERA);

		this.perfilDao.insertarPerfil(perfil);
		int numeroPerfiles = this.jdbcTemplate.queryForObject("SELECT count(*) FROM " + Tablas.PERFIL
				+ " WHERE WPRIDPERFIL = 999", Integer.class);

		Assert.assertEquals(numeroPerfiles, 1);
	}

	public void setPerfilDao(PerfilDao perfilDao) {
		this.perfilDao = perfilDao;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
