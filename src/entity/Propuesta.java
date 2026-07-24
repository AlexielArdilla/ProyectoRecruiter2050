package entity;

public class Propuesta {

	private int id;
	private String cargo;
	private String texto;
	
	
	
	
	public Propuesta() {
		
		this.cargo = "No disponible";
		this.texto = "No disponible";
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
	
	
}
