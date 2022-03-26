package net.izfe.g240.wfiguiarapida.core.validators;

import net.izfe.g240.wfiguiarapida.core.beans.Cuenta;
import net.izfe.g240.wfiguiarapida.core.facades.CuentasFacade;
import net.izfe.g240.wfiguiarapida.web.beans.CuentaForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UsuarioExistenteValidator implements Validator {

	@Autowired
	private CuentasFacade cuentasFacade;

	@Override
	public boolean supports(Class<?> clazz) {
		return CuentaForm.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		String idUsuario = ((CuentaForm) object).getCuenta().getIdUsuario();

		if (StringUtils.hasText(idUsuario)) {
			Cuenta cuenta = cuentasFacade.leerCuenta(idUsuario);

			if (cuenta != null) {
				errors.rejectValue("cuenta.idUsuario", "errors.idusuario.existente");
			}
		}
	}

}
