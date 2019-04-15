package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbConnection.MyConnection;
import entity.Candidato;



public class CandidatoDAOImpl implements CandidatoDAO{

	@Override
	public List<Candidato> getCandidatos() {
		
			
			List<Candidato> candidatos = new ArrayList<>();
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				con = MyConnection.getConnection();
				ps = con.prepareStatement(
						"SELECT `id_candidato`, `nombre_apel`, `edad`, `dni`, `estado`,"
						+ " `avatar` FROM `candidatos` WHERE 1");
				rs = ps.executeQuery();

				while (rs.next()) {

					Candidato candidato = new Candidato();
				
					candidato.setId(rs.getInt(1));
					candidato.setNombre_apel(rs.getString(2));
					candidato.setEdad(rs.getInt(3));
					candidato.setDni(rs.getInt(4));
					candidato.setEstado(rs.getString(5));
					candidato.setAvatar(rs.getInt(6));
					
					
					candidatos.add(candidato);
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
							
			return candidatos;
			
		
	}
	
	public Candidato getCandidatoById(int id){
		
		Candidato candidato = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement(
					"SELECT `id_candidato`, `nombre_apel`, `edad`,`dni`, `estado`,"
					+ " `avatar` FROM `candidatos` WHERE id_candidato = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {

			    candidato = new Candidato();
			
				candidato.setId(rs.getInt(1));
				candidato.setNombre_apel(rs.getString(2));
				candidato.setEdad(rs.getInt(3));
				candidato.setDni(rs.getInt(4));
				candidato.setEstado(rs.getString(5));
				candidato.setAvatar(rs.getInt(6));
				
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
						
		return candidato;
	}

	@Override
	public int cargarCandidato(Candidato candidato) {

		Connection con = null;
		PreparedStatement ps = null;
		int r = 0;
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement(
					"INSERT INTO `candidatos`( `nombre_apel`, `edad`, `dni`, `estado`, `avatar`) VALUES ( ?, ?, ?, ?, 0)");
			
			ps.setString(1, candidato.getNombre_apel());
			ps.setInt(2, candidato.getEdad());
			ps.setInt(3, candidato.getDni());
			ps.setString(4, candidato.getEstado());
			
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

	@Override
	public int bajaCandidatoById(int id) {


		Connection con = null;
		PreparedStatement ps = null;
		int r = 0;
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement("DELETE FROM `candidatos` WHERE id_candidato = ?");
			
			ps.setInt(1, id);
			
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

	@Override
	public int actualizarEstado(int id_candidato, String estado) {
		
		Connection con = null;
		PreparedStatement ps = null;
		int r = 0;
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement("UPDATE `candidatos` SET `estado`= ? WHERE `id_candidato` = ?");
			
			ps.setString(1, estado);
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
