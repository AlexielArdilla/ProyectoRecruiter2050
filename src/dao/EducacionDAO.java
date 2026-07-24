package dao;
import java.util.List;

import entity.Educacion;

public interface EducacionDAO {
	
	public List<Educacion> getEducacionByIdCandidato(int id);

}
