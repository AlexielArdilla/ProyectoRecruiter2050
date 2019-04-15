package dao;
import java.util.List;

import entity.Candidato;

public interface CandidatoDAO {
	
	public List<Candidato> getCandidatos();
	
	public int cargarCandidato(Candidato candidato);
	
	public int bajaCandidatoById(int id);
	
	public int actualizarEstado(int id_candidato, String estado);
	
	public Candidato getCandidatoById(int id);

}
