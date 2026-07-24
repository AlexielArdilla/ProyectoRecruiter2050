package dao;
import java.util.List;

import entity.Candidato;


public interface BuscadorDAO {
	
	public List<Candidato> buscarCandidatoPorNombre(String nombre);

}
