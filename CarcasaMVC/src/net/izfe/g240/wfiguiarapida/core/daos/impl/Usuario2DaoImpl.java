package net.izfe.g240.wfiguiarapida.core.daos.impl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import net.izfe.g240.wfiframeworkizfelib.datos.jdbc.namedparam.MultipleBeanPropertySqlParameterSource;
import net.izfe.g240.wfiframeworkizfelib.datos.jdbc.rowmapper.BeanPropertyRowMapperExtension;
import net.izfe.g240.wfiguiarapida.core.beans.Cuenta;
import net.izfe.g240.wfiguiarapida.core.beans.Usuario2;
import net.izfe.g240.wfiguiarapida.core.daos.Usuario2Dao;
import net.izfe.g240.wfiguiarapida.core.rowmappers.UsuarioRowMapper;

@Repository
public class Usuario2DaoImpl implements Usuario2Dao {

	   private List<Usuario2> usuarios ;
	   @Autowired
		private JdbcTemplate jdbcTemplate2;
		@Autowired
		@Qualifier("namedParameterJdbcTemplate2")
		private NamedParameterJdbcTemplate namedJdbcTemplate;


		
		@Override
		public List<Usuario2> getUsuarios() {
		
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT * FROM usuarios ");
			RowMapper usuarioRowMapper= new UsuarioRowMapper();

			return this.jdbcTemplate2.query(sql.toString(), usuarioRowMapper);
			
		}


		@Override
		public void nuevoUsuario(Usuario2 usuario) {
		
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO usuarios  ('UsuarioId','Nombre','Apellido','Password','Telefono','Direccion','Email')") 
			.append(" VALUES(:usuario.idUsuario,:usuario.nombre,:usuario.apellido,:usuario:password,:usuario.telefono,:usuario.direccion,:usuario.email)");
			Map<String, Usuario2> paramMap = Collections.singletonMap("usuario", usuario);
			SqlParameterSource namedParameters = new MultipleBeanPropertySqlParameterSource(paramMap);
        
			this.namedJdbcTemplate.update(sql.toString(), namedParameters);
		}
	
}
