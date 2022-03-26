package net.izfe.g240.wfiguiarapida.core.daos;

import java.util.List;

import org.springframework.ui.Model;
import net.izfe.g240.wfiguiarapida.core.beans.Usuario2;


public interface Usuario2Dao {

	List<Usuario2> getUsuarios();
	
	void nuevoUsuario(Usuario2 usuario);
	
}
