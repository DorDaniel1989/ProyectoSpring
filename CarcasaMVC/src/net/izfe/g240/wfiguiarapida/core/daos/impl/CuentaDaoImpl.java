package net.izfe.g240.wfiguiarapida.core.daos.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import net.izfe.g240.wfiframeworkizfelib.datos.jdbc.namedparam.MultipleBeanPropertySqlParameterSource;
import net.izfe.g240.wfiframeworkizfelib.datos.jdbc.rowmapper.BeanPropertyRowMapperExtension;
import net.izfe.g240.wfiframeworkizfelib.datos.jdbc.rsextractor.RSExtractorIzfeForBean;
import net.izfe.g240.wfiframeworkizfelib.paginacion.db.PaginacionDaoHelperIzfe;
import net.izfe.g240.wfiframeworkizfelib.paginacion.db.PaginacionHandlerIzfe;
import net.izfe.g240.wfiguiarapida.core.beans.Cuenta;
import net.izfe.g240.wfiguiarapida.core.beans.Perfil;
import net.izfe.g240.wfiguiarapida.core.daos.CuentaDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class CuentaDaoImpl implements CuentaDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(CuentaDaoImpl.class);

	@Autowired
	@Qualifier("namedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;

	private PaginacionDaoHelperIzfe paginacionHelper = new PaginacionDaoHelperIzfe("WCT");

	private final ResultSetExtractor<Cuenta> resultSetExtractor = new RSExtractorIzfeForBean<Cuenta>() {
		protected void registrarMappers() {
			registrarBeanMapper("cuenta", "WCTIDUSUARIO", Cuenta.class, "WCT");
			registrarBeanMapper("cuenta.perfil", new String[] { "WCTIDUSUARIO", "WPRIDPERFIL" }, Perfil.class, "WPR");
		}
	};

	/**
	 * Inserta una nueva cuenta de usuario en la base de datos con la informaci�n de <code>cuenta</code>.
	 * 
	 * @param cuenta
	 *            Nueva cuenta de usuario
	 */
	public void insertarCuenta(Cuenta cuenta) {

		LOGGER.debug("Insertar Cuenta: [idUsuario: {}]", cuenta.getIdUsuario());

		StringBuffer sql = new StringBuffer();

		sql.append("INSERT INTO ")
				.append(Tablas.CUENTA)
				.append(" (WCTIDUSUARIO, WCTPASSWORD, WCTEMAIL, WCTNOMBRE, WCTAPELLIDO, WCTTELEFONO, WCTFCREACION)")
				.append(" VALUES(:cuenta.idUsuario,:cuenta.password,:cuenta.email,:cuenta.nombre,:cuenta.apellido,:cuenta.telefono,:cuenta.fcreacion)");

		Map<String, Cuenta> paramMap = Collections.singletonMap("cuenta", cuenta);
		SqlParameterSource namedParameters = new MultipleBeanPropertySqlParameterSource(paramMap);

		this.jdbcTemplate.update(sql.toString(), namedParameters);
		
	}

	/**
	 * @return Devuelve todas las cuentas de usuario.
	 */
	public List<Cuenta> leerCuentas(PaginacionHandlerIzfe paginacionHandler) {

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT WCTIDUSUARIO, WCTNOMBRE, WCTAPELLIDO, WCTEMAIL, WCTTELEFONO, WCTFCREACION FROM ").append(Tablas.CUENTA);

		RowMapper<Cuenta> cuentaRowMapper = new BeanPropertyRowMapperExtension<Cuenta>(Cuenta.class, 3);

		MapSqlParameterSource parametros = null;
		if (paginacionHandler != null) {
			parametros = paginacionHelper.modificarSql(sql, paginacionHandler);

			LOGGER.debug("SQL con paginacion: {}", sql.toString());
		}

		return this.jdbcTemplate.query(sql.toString(), parametros, cuentaRowMapper);
	}

	public Cuenta leerCuenta(String idUsuario) {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"SELECT WCTIDUSUARIO, WCTNOMBRE, WCTPASSWORD, WCTEMAIL, WCTAPELLIDO, WCTTELEFONO, WPRIDPERFIL, WPRIDIOMA")
				.append(" FROM ").append(Tablas.CUENTA).append(" LEFT JOIN ").append(Tablas.PERFIL)
				.append(" ON WCTIDUSUARIO = WPRIDUSUARIO").append(" WHERE ").append("WCTIDUSUARIO = ?");

		return this.jdbcTemplate.getJdbcOperations().query(sql.toString(), new Object[] { idUsuario },
				resultSetExtractor);
	}

	public int numeroCuentas() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*)").append(" FROM ").append(Tablas.CUENTA);

		return this.jdbcTemplate.getJdbcOperations().queryForObject(sql.toString(), Integer.class);

	}
}