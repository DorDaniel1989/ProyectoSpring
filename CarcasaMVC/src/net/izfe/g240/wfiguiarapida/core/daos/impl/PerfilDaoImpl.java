package net.izfe.g240.wfiguiarapida.core.daos.impl;

import java.util.Collections;
import java.util.Map;

import net.izfe.g240.wfiframeworkizfelib.datos.jdbc.namedparam.MultipleBeanPropertySqlParameterSource;
import net.izfe.g240.wfiguiarapida.core.beans.Perfil;
import net.izfe.g240.wfiguiarapida.core.daos.PerfilDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class PerfilDaoImpl implements PerfilDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(PerfilDaoImpl.class);

	@Autowired
	@Qualifier("namedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;

	/**
	 * Inserta un nuevo perfil de usuario en la base de datos con la informaci�n de <code>perfil</code>.
	 * 
	 * @param perfil
	 *            Nuevo perfil de usuario
	 */
	public void insertarPerfil(Perfil perfil) {

		LOGGER.debug("Insertar Perfil [idPerfil: {}, idUsuario: {}]", perfil.getIdPerfil(), perfil.getCuenta().getIdUsuario());

		StringBuffer sql = new StringBuffer();

		sql.append("INSERT INTO ").append(Tablas.PERFIL).append(" (WPRIDPERFIL, WPRIDIOMA, WPRIDUSUARIO) ")
				.append(" VALUES(:perfil.idPerfil, :perfil.idioma, :perfil.cuenta.idUsuario)");

		Map<String, Perfil> paramMap = Collections.singletonMap("perfil", perfil);
		SqlParameterSource namedParameters = new MultipleBeanPropertySqlParameterSource(paramMap);

		this.jdbcTemplate.update(sql.toString(), namedParameters);
	}

	public int obtenerSiguienteId() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT MAX(WPRIDPERFIL) FROM ").append(Tablas.PERFIL);

		return this.jdbcTemplate.getJdbcOperations().queryForObject(sql.toString(), Integer.class) + 1;
	}
}
