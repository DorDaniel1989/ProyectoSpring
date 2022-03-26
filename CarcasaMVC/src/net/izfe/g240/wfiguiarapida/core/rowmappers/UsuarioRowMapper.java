package net.izfe.g240.wfiguiarapida.core.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import net.izfe.g240.wfiguiarapida.core.beans.Usuario2;

public class UsuarioRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Usuario2 usuario= new Usuario2();
		
		usuario.setUsuarioId(rs.getString("UsuarioId"));
		usuario.setNombre(rs.getString("Nombre"));
		usuario.setApellido(rs.getString("Apellido"));
		usuario.setPassword(rs.getString("Password"));
		usuario.setEmail(rs.getString("Email"));
		usuario.setTelefono(rs.getString("Direccion"));
		usuario.setDireccion(rs.getString("Telefono"));
	
		return usuario;
	}



}
