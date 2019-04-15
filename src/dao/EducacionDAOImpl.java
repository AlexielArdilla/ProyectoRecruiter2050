package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dbConnection.MyConnection;
import entity.Educacion;

public class EducacionDAOImpl implements EducacionDAO{

	@Override
	public List<Educacion> getEducacionByIdCandidato(int id) {
		
		List<Educacion> misEducaciones = new LinkedList<>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement("SELECT `id`, `texto`, `id_candidato`, `colegio`, `calificacion`, `puntaje` FROM `educacion` WHERE id_candidato = ?");
			ps.setInt(1, id);
			rs= ps.executeQuery();
			
			while(rs.next()){
				Educacion miEducacion = new Educacion();
				miEducacion.setId(rs.getInt(1));
				miEducacion.setTexto(rs.getString(2));
				miEducacion.setId_candidato(rs.getInt(3));
				miEducacion.setColegio(rs.getString(4));
				miEducacion.setCalificacion(rs.getDouble(5));
				miEducacion.setPuntaje(rs.getInt(6));
				
				misEducaciones.add(miEducacion);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return misEducaciones;
	}

}
