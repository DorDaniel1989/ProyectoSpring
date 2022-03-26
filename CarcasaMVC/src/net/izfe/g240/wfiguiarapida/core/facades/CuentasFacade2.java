package net.izfe.g240.wfiguiarapida.core.facades;

import java.util.List;

import net.izfe.g240.wfiguiarapida.core.beans.Usuario2;



public interface CuentasFacade2 {

	 List<Usuario2>leerUsuarios();
	 void nuevoUsuario(Usuario2 usuario);
	
}
