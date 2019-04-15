package dao;

import entity.Curriculum;

public interface CurriculumDAO {
	
	public Curriculum getCVByIdCandidato(int id);
	
	public int cargarpropuestaAcandidato(int id_propuesta, int id_candidato);
}
