package net.izfe.g240.wfiguiarapida.web.beans;

import javax.validation.Valid;

import net.izfe.g240.wfiframeworkizfelib.validator.constraints.NotBlank;
import net.izfe.g240.wfiguiarapida.core.beans.Cuenta;
import net.izfe.g240.wfiguiarapida.core.validators.CuentasWizardValidations.DatosUsuario;

/**
 * No es obligatorio crear un bean tipo Form para los formularios. En este caso se ha creado este form porque se quiere
 * recoger una propiedad (repetirPassword) que no existe en el bean de lógica de negocio.
 */
public class CuentaForm {
	@Valid
	private Cuenta cuenta;

	@NotBlank(groups = DatosUsuario.class)
	private String repetirPassword;

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public String getRepetirPassword() {
		return repetirPassword;
	}

	public void setRepetirPassword(String repetirPassword) {
		this.repetirPassword = repetirPassword;
	}
}