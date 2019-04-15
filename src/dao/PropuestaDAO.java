package dao;
import java.util.List;

import entity.Propuesta;

public interface PropuestaDAO {
	
	public Propuesta getPropuestaById(int id);
	
	public int cargarPropuesta(Propuesta propuesta);
	
	public int modPropuesta(Propuesta propuesta);
	
	public List<Propuesta> getAllPropuestas();

	public int bajaPropuestaById(int id);
}
