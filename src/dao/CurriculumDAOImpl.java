package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbConnection.MyConnection;
import entity.Curriculum;

public class CurriculumDAOImpl implements CurriculumDAO{

	@Override
	public Curriculum getCVByIdCandidato(int id) {

		Curriculum curriculum = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement("SELECT `id`, `id_candidato`, `email`, `web`, `cel`, `puntaje`, `propuesta_id` FROM `cabecera_cv` WHERE id_candidato = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {

			    curriculum = new Curriculum();
			
				curriculum.setId(rs.getInt(1));
				curriculum.setId_candidato(rs.getInt(2));
				curriculum.setEmail(rs.getString(3));
				curriculum.setWeb(rs.getString(4));
				curriculum.setCel(rs.getInt(5));
				curriculum.setPuntaje(rs.getInt(6));
				curriculum.setPropuestaId(rs.getInt(7));
			}
			
		} catch (SQLException e) {		
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}										
		}
						
		return curriculum;
		
	}

	@Override
	public int cargarpropuestaAcandidato(int id_propuesta, int id_candidato) {

	
		Connection con = null;
		PreparedStatement ps = null;
		int r = 0;
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement("UPDATE `cabecera_cv` SET `propuesta_id`= ? WHERE `id_candidato` = ?");
			ps.setInt(1, id_propuesta);
			ps.setInt(2, id_candidato);
			r = ps.executeUpdate();

			
		} catch (SQLException e) {		
			e.printStackTrace();
		} finally {
			try {
				
				ps.close();
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}										
		}
		
		
		return r;
	}

}
