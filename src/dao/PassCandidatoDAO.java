package dao;

import java.util.List;

import entity.PassCandidato;

public interface PassCandidatoDAO {
	
	public int cargarPassCandidatoByCandId(String user, String pass, int id);
	
	public List<PassCandidato> getAllPassCandidatos();
	
	public int borrarPassCandidatoByUser(String user);

}
