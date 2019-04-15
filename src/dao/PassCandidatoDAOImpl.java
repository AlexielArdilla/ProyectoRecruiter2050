package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbConnection.MyConnection;
import entity.Candidato;
import entity.PassCandidato;

public class PassCandidatoDAOImpl implements PassCandidatoDAO{

	@Override
	public int cargarPassCandidatoByCandId(String user, String pass, int id) {
		Connection con = null;
		PreparedStatement ps = null;
		int r = 0;
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement(
					"INSERT INTO `candidato_pass`(`user`, `pass`, `id_candidato`) VALUES ( ?, ?, ?)");
			
			ps.setString(1, user);
			ps.setString(2, pass);
			ps.setInt(3, id);
			
			
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
	
	public List<PassCandidato> getAllPassCandidatos(){
		
		List<PassCandidato> misPassCandidatos = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement(
					"SELECT `user`, `pass`, `nombre_apel` FROM `candidato_pass` "
					+ "JOIN candidatos "
					+ "ON candidato_pass.id_candidato = candidatos.id_candidato");
			rs = ps.executeQuery();

			while (rs.next()) {

				PassCandidato miPassCandidato = new PassCandidato();
			
				miPassCandidato.setUser(rs.getString(1));
				miPassCandidato.setPass(rs.getString(2));
				miPassCandidato.setNombre_apel(rs.getString(3));
				
				misPassCandidatos.add(miPassCandidato);
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
						
		return misPassCandidatos;
		
	}

	@Override
	public int borrarPassCandidatoByUser(String user) {
		
		Connection con = null;
		PreparedStatement ps = null;
		int r = 0;
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement("DELETE FROM `candidato_pass` WHERE `user`= ?");
			ps.setString(1, user);
			
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
