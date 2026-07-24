package dao;
import java.util.List;

import entity.Experiencia;

public interface ExperienciaDAO {
	
	public List<Experiencia> getExperienciasByIDCandidato(int id);

}
