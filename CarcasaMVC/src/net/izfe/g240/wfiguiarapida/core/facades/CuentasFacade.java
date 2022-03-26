package net.izfe.g240.wfiguiarapida.core.facades;

import java.util.List;

import net.izfe.g240.wfiframeworkizfelib.paginacion.db.PaginacionHandlerIzfe;
import net.izfe.g240.wfiguiarapida.core.beans.Cuenta;

public interface CuentasFacade {

	/**
	 * Inserta una nueva cuenta de usuario en la base de datos con la información de <code>cuenta</code>. Además inserta
	 * el nuevo perfil para el mismo identificador de usuario.
	 * 
	 * @param cuenta
	 *            Nueva cuenta de usuario
	 */
	void crearCuenta(Cuenta cuenta);

	/**
	 * @return Devuelve todas las cuentas de usuario.
	 */
	List<Cuenta> leerCuentas(PaginacionHandlerIzfe paginacionHandler);

	/**
	 * Número de cuentas total existentes
	 * 
	 * @return numero de cuentas
	 */
	int numeroCuentas();

	/**
	 * @param idUsuario
	 *            id de usuario
	 * @return
	 */
	Cuenta leerCuenta(String idUsuario);

	/**
	 * Inserta una nueva cuenta de usuario en la base de datos con la información de <code>cuenta</code>. Además inserta
	 * el nuevo perfil para el mismo identificador de usuario. En este caso en mitad de la transacción se produce una
	 * excepción de tipo unchecked, y por consiguiente se realiza un rollback.
	 * 
	 * @param cuenta
	 *            Nueva cuenta de usuario
	 */
	void crearCuentaConErrorUnchecked(Cuenta cuenta);

	/**
	 * Inserta una nueva cuenta de usuario en la base de datos con la información de <code>cuenta</code>. Además inserta
	 * el nuevo perfil para el mismo identificador de usuario. En este caso en mitad de la transacción se produce una
	 * excepción de tipo checked, y por consiguiente se realiza un rollback.
	 * 
	 * @param cuenta
	 *            Nueva cuenta de usuario
	 */
	void crearCuentaConErrorChecked(Cuenta cuenta) throws IllegalAccessException;

}
