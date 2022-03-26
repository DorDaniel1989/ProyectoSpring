package net.izfe.g240.wfiguiarapida.core.validators;

import net.izfe.g240.wfiguiarapida.core.beans.Cuenta;
import net.izfe.g240.wfiguiarapida.core.facades.CuentasFacade;
import net.izfe.g240.wfiguiarapida.web.beans.CuentaWizard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Esto es un ejemplo de validador para el wizard. En realidad, es una copia del validador {@link UsuarioExistenteValidator}.
 * En una aplicación real para evitar copiar el validador, habría que crear un interface que implementen ambos beans. El interface
 * tendría el método getIdUsuario y el método support del validador comprobaría si implementa dicha interface o no.
 */
@Component
public class UsuarioWizardExistenteValidator implements Validator {

	@Autowired
	private CuentasFacade cuentasFacade;

	@Override
	public boolean supports(Class<?> clazz) {
		return CuentaWizard.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		String idUsuario = ((CuentaWizard) object).getIdUsuario();

		if (StringUtils.hasText(idUsuario)) {
			Cuenta cuenta = cuentasFacade.leerCuenta(idUsuario);

			if (cuenta != null) {
				errors.rejectValue("idUsuario", "errors.idusuario.existente");
			}
		}
	}
	
}
