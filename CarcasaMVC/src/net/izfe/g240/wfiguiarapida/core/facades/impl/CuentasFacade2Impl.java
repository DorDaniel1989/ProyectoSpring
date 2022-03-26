package net.izfe.g240.wfiguiarapida.core.facades.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import net.izfe.g240.wfiguiarapida.core.beans.Usuario2;
import net.izfe.g240.wfiguiarapida.core.daos.Usuario2Dao;
import net.izfe.g240.wfiguiarapida.core.facades.CuentasFacade2;
@Service
public class CuentasFacade2Impl implements CuentasFacade2 {

	@Autowired
	Usuario2Dao usuario2Dao;
	
	@Override
	public List<Usuario2> leerUsuarios() {
		
		return usuario2Dao.getUsuarios();
	}

	@Override
	public void nuevoUsuario(Usuario2 usuario) {
		
		usuario2Dao.nuevoUsuario(usuario);
		
	}


}
