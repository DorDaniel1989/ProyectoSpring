package net.izfe.g240.wfiguiarapida.core.daos;

import java.util.List;

import net.izfe.g240.wfiframeworkizfelib.paginacion.db.PaginacionHandlerIzfe;
import net.izfe.g240.wfiguiarapida.core.beans.Cuenta;

public interface CuentaDao {

	/**
	 * Inserta una nueva cuenta de usuario en la base de datos con la informaci�n de <code>cuenta</code>.
	 * 
	 * @param cuenta
	 *            Nueva cuenta de usuario
	 */
	void insertarCuenta(Cuenta cuenta);

	/**
	 * @return Devuelve todas las cuentas de usuario.
	 */
	List<Cuenta> leerCuentas(PaginacionHandlerIzfe paginacionHandler);

	/**
	 * @param idUsuario
	 * @return Cuenta de usuario
	 */
	Cuenta leerCuenta(String idUsuario);

	/**
	 * N�mero de cuentas total existentes
	 * 
	 * @return numero de cuentas
	 */
	int numeroCuentas();

}
