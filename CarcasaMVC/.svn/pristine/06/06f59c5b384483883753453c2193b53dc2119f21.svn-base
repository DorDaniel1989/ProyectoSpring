package net.izfe.g240.wfiguiarapida.core.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public abstract class Roles {

	/** Role usuario */
	public static final GrantedAuthority USER = new SimpleGrantedAuthority("ROLE_USER");
	
	/** Role administrador */
	public static final GrantedAuthority ADMIN = new SimpleGrantedAuthority("ROLE_ADMIN");
	
	/**
	 * @param s Código del role que devuelve accesos ññññ
	 * @return El role correspondiente al código de accesos
	 */
	public static final GrantedAuthority valueOf(short s) {
		switch (s) {
		case 1:
			return USER;
		case 2:
			return ADMIN;
		default:
			throw new IllegalArgumentException("No se soporta el rol " + s);	
		}
	}
}
