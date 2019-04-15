package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dbConnection.MyConnection;
import entity.Experiencia;

public class ExperienciaDAOImpl implements ExperienciaDAO{

	@Override
	public List<Experiencia> getExperienciasByIDCandidato(int id) {

		List<Experiencia> misExperiencias = new LinkedList<>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement("SELECT `id`, `texto`, `id_candidato`, `cargo`, `desde`, `hasta`,"
					+ " `puntaje` FROM `experiencia` WHERE `id_candidato` = ?");
			ps.setInt(1, id);
			rs= ps.executeQuery();
			
			while(rs.next()){
				Experiencia miExperiencia = new Experiencia();
				
				miExperiencia.setId(rs.getInt(1));
				miExperiencia.setTexto(rs.getString(2));
				miExperiencia.setId_candidato(rs.getInt(3));
				miExperiencia.setCargo(rs.getString(4));
				miExperiencia.setDesde(rs.getDate(5));
				miExperiencia.setHasta(rs.getDate(6));
				miExperiencia.setPuntaje(rs.getInt(7));
				
				misExperiencias.add(miExperiencia);
				
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
		
		
		
		return misExperiencias;
	}

	
	
}
