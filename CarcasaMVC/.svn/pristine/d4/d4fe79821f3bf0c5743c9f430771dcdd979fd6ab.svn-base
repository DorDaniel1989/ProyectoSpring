package net.izfe.g240.wfiguiarapida.core.security;

import java.util.Collections;

import net.izfe.g240.wfiguiarapida.core.beans.Usuario;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class GuiaRapidaUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String token) throws UsernameNotFoundException {
		if ("111".equals(token)) {
			throw new UsernameNotFoundException("Token 111 no valido");
		}
		
		//Llamada a Accesos y mapear las propiedades
		String username = "user_" + token;
		GrantedAuthority authority = Roles.USER;
		if ("000".equals(token)) {
			authority = Roles.ADMIN;
		}
		
		//Crear usuario con nombre de usuario y role
		return new Usuario(username, Collections.singleton(authority));
	}

}
