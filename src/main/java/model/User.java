package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "TUsers")
public class User {
	@Id
	private Long id;
	private String nombre;
	private String apellidos;
	private String email;
	private String fechaNacimiento; // Lo dejo en String de momento. Hay que
									// hablarlo con el otro grupo.
	private String direccionPostal;
	private String nacionalidad;
	private String DNI;
	private String username;
	private String password;

	public User() {
	} // Constructor vacio para JPA

	public User(String nombre, String apellidos, String email,
				String fechaNacimiento, String direccionPostal,
				String nacionalidad, String DNI) {
		setNombre(nombre);
		setApellidos(apellidos);
		setEmail(email);
		setFechaNacimiento(fechaNacimiento);
		setDireccionPostal(direccionPostal);
		setNacionalidad(nacionalidad);
		setDNI(DNI);
		generarUsername();
		generarPassword();
	}

	private void setPassword(String password) {
		this.password = password;
	}

	private void setUsername(String username) {
		this.username = username;
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	private void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		this.email = email;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	private void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccionPostal() {
		return direccionPostal;
	}

	private void setDireccionPostal(String direccionPostal) {
		this.direccionPostal = direccionPostal;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	private void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getDNI() {
		return DNI;
	}

	private void setDNI(String DNI) {
		this.DNI = DNI;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DNI == null) ? 0 : DNI.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (DNI == null) {
			if (other.DNI != null)
				return false;
		} else if (!DNI.equals(other.DNI))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nombre=" + nombre + ", apellidos="
				+ apellidos + ", email=" + email + ", fechaNacimiento="
				+ fechaNacimiento + ", direccionPostal=" + direccionPostal
				+ ", nacionalidad=" + nacionalidad + ", DNI=" + DNI + "]";
	}
	
	private void generarUsername()
	{
		String username = "";
		int low = 65;
		int top = 90;
		for(int i = 0; i<12; i++){
			int numAleatorio = (int)Math.floor(Math.random()*(top - low) + low);
			username += (char)numAleatorio;
		}
		setUsername(username);
	}
	
	private void generarPassword()
	{
		String pass = "";
		int low = 65;
		int top = 90;
		for(int i = 0; i<9; i++){
			int numAleatorio = (int)Math.floor(Math.random()*(top - low) + low);
			pass += (char)numAleatorio;
		}
		for(int i = 0; i<3; i++){
			int numAleatorio = (int)Math.floor(Math.random()*(9 - 0) + 0);
			pass += numAleatorio;
		}
		setPassword(pass);
	}
}
