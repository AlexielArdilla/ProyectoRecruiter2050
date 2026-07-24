package entity;

import java.util.List;

public class Curriculum {
	
	private int id;
	private int cel;
	private String email;
	private int id_candidato;
	private String web;
	private int propuesta_id;
	private int puntaje;
	
	private Lema lema;
	
	private List<Educacion> educaciones;
	private List<Experiencia> experiencias;
	private List<Skill> skills;
	
	
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
	public Lema getLema() {
		return lema;
	}
	public void setLema(Lema lema) {
		this.lema = lema;
	}
	public int getCel() {
		return cel;
	}
	public void setCel(int cel) {
		this.cel = cel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId_candidato() {
		return id_candidato;
	}
	public void setId_candidato(int id_candidato) {
		this.id_candidato = id_candidato;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	public int getPropuestaId() {
		return propuesta_id;
	}
	public void setPropuestaId(int propuesta_id) {
		this.propuesta_id = propuesta_id;
	}
	public List<Educacion> getEducaciones() {
		return educaciones;
	}
	public void setEducaciones(List<Educacion> educaciones) {
		this.educaciones = educaciones;
	}
	public List<Experiencia> getExperiencias() {
		return experiencias;
	}
	public void setExperiencias(List<Experiencia> experiencias) {
		this.experiencias = experiencias;
	}
	public List<Skill> getSkills() {
		return skills;
	}
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	
	

}
