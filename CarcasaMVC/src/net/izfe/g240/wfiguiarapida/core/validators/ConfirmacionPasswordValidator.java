package net.izfe.g240.wfiguiarapida.core.validators;

import net.izfe.g240.wfiguiarapida.web.beans.CuentaForm;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ConfirmacionPasswordValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return CuentaForm.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		CuentaForm cuentaForm = (CuentaForm) object;

		if (cuentaForm.getRepetirPassword() != null
				&& !cuentaForm.getRepetirPassword().equals(cuentaForm.getCuenta().getPassword())) {
			errors.rejectValue("repetirPassword", "errors.confirmacion.password.incorrecto");
		}
	}

}
