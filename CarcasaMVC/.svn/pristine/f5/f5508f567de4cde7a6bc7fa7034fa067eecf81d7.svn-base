package net.izfe.g240.wfiguiarapida.web.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import net.izfe.g240.wfiguiarapida.core.beans.Cuenta;

@XmlRootElement(name = "cuentas")
public class CuentasWrapper {

	private List<Cuenta> cuentas;

	// Constructor por defecto para JAXB
	public CuentasWrapper() {
	}

	public CuentasWrapper(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	// Si no se pone aquí la anotación XmlElement cada item de la lista es un nodo <cuentas>
	// Hay que poner el @XmlElement sobre el getter, no sobre la propiedad sino da error: Class has two properties of
	// the same name "cuentas"
	@XmlElement(name = "cuenta", type = Cuenta.class)
	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

}
