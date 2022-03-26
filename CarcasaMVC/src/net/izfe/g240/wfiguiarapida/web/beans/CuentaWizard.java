package net.izfe.g240.wfiguiarapida.web.beans;
 
import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import net.izfe.g240.wfiframeworkizfelib.validator.constraints.Email;
import net.izfe.g240.wfiframeworkizfelib.validator.constraints.NotEmpty;
import net.izfe.g240.wfiframeworkizfelib.validator.constraints.Range;
import net.izfe.g240.wfiguiarapida.core.validators.CuentasWizardValidations.DatosUsuario;
import net.izfe.g240.wfiguiarapida.core.validators.CuentasWizardValidations.InformacionCuenta;
import net.izfe.g240.wfiguiarapida.core.validators.CuentasWizardValidations.InformacionPerfil;

/**
 * El formulario wizard de la guía rápida es un ejemplo sencillo para demostrar cómo se utilizan las anotaciones de
 * validación y los grupos. Para evitar complicar la aplicación creando una nueva entidad con sus correspondientes clases
 * facade y dao, se ha reutilizado las clases de Cuenta y se ha creado una nueva entidad CuentaWizard que tiene los
 * grupos de validaciones. En un aplicación real no es necesario crear un bean de presentación para poner los grupos de validaciones,
 * se pueden utilizar sobre el bean de lógica de negocio. 
 */
@XmlRootElement
public class CuentaWizard implements Serializable {

	private static final long serialVersionUID = -7003426749477963920L;

	@NotEmpty(groups = DatosUsuario.class)
	private String idUsuario;

	@NotEmpty(groups = DatosUsuario.class)
	private String password;

	@NotEmpty(groups = InformacionCuenta.class)
	private String nombre;

	@NotEmpty(groups = InformacionCuenta.class)
	private String apellido;

	@NotNull(groups = InformacionCuenta.class)
	@Range(min=800000000, max=999999999, groups = InformacionCuenta.class)
	private Integer telefono;
	
	@Email(groups = InformacionPerfil.class)
	@NotEmpty(groups = InformacionPerfil.class)
	private String email;

	@NotNull(groups = InformacionPerfil.class)
	private Date fcreacion = new Date();

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFcreacion() {
		return fcreacion;
	}

	public void setFcreacion(Date fechaCreacion) {
		this.fcreacion = fechaCreacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

}
