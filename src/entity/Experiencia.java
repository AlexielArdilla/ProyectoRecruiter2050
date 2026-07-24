package entity;

import java.sql.Date;

public class Experiencia {
	
	private int id;
	private String cargo;
	private Date desde;
	private Date hasta;
	private int id_candidato;
	private String texto;
	private int puntaje;
	
	
	
	
	@Override
	public String toString() {
		return "Experiencia [id=" + id + ", cargo=" + cargo + ", desde=" + desde + ", hasta=" + hasta
				+ ", id_candidato=" + id_candidato + ", texto=" + texto + ", puntaje=" + puntaje + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Date getDesde() {
		return desde;
	}
	public void setDesde(Date desde) {
		this.desde = desde;
	}
	public Date getHasta() {
		return hasta;
	}
	public void setHasta(Date hasta) {
		this.hasta = hasta;
	}
	public int getId_candidato() {
		return id_candidato;
	}
	public void setId_candidato(int id_candidato) {
		this.id_candidato = id_candidato;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	

}
