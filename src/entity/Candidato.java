package entity;

public class Candidato {
	
	private String nombre_apel;
	private int edad;
	private int dni; 
	private String estado; //seleccionado, preseeleccionado, etc
	private int id;
	private int avatar = 0;
	
	public int getAvatar() {
		return avatar;
	}
	public void setAvatar(int avatar) {
		this.avatar = avatar;
	}
	public String getNombre_apel() {
		return nombre_apel;
	}
	public void setNombre_apel(String nombre_apel) {
		this.nombre_apel = nombre_apel;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
