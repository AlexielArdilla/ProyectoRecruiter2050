package entity;

public class PassCandidato {

	private String user;
	private String pass;
	private String nombre_apel="";
	private int id_candidato = 0;
	
	
	
	public String getNombre_apel() {
		return nombre_apel;
	}
	public void setNombre_apel(String nombre_apel) {
		this.nombre_apel = nombre_apel;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getId_candidato() {
		return id_candidato;
	}
	public void setId_candidato(int id_candidato) {
		this.id_candidato = id_candidato;
	}
	
	
	
	
}
