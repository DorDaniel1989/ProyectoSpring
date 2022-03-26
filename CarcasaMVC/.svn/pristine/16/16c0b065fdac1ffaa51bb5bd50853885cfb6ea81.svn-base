package net.izfe.g240.wfiguiarapida.core.beans;
 
import java.io.Serializable;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import net.izfe.g240.wfiframeworkizfelib.validator.constraints.Email;
import net.izfe.g240.wfiframeworkizfelib.validator.constraints.Length;
import net.izfe.g240.wfiframeworkizfelib.validator.constraints.NIF;
import net.izfe.g240.wfiframeworkizfelib.validator.constraints.NotEmpty;
import net.izfe.g240.wfiframeworkizfelib.validator.constraints.Range;

@XmlRootElement
public class Cuenta implements Serializable {
//
	private static final long serialVersionUID = -7003426749477963920L;

	@Length(min = 5, max = 10)
	private String idUsuario;

	@NotEmpty
	private String password;

	@Email
	@NotEmpty
	private String email;

	@NotEmpty
	private String nombre;

	@org.hibernate.validator.constraints.Length(min = 3, max = 10)
	private String apellido;

	@NotNull
	@Range(min=800000000, max=999999999)
	private Integer telefono;

	@NotNull
	private Date fcreacion = new Date();

	@Valid
	@NotNull
	private Perfil perfil = new Perfil();

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

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
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
