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

public class BuscadorDAOImpl implements BuscadorDAO{

	@Override
	public List<Candidato> buscarCandidatoPorNombre(String nombre) {

		List<Candidato> misCandidatos = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement("SELECT `id_candidato`, `nombre_apel`,"
					+ " `edad`, `dni`, `estado`, `avatar` FROM `candidatos`"
					+ " WHERE `nombre_apel` LIKE '%"+nombre+"%'");

			rs = ps.executeQuery();

			while (rs.next()) {

				Candidato miCandidato = new Candidato();
			
				miCandidato.setId(rs.getInt(1));
				miCandidato.setNombre_apel(rs.getString(2));
				miCandidato.setEdad(rs.getInt(3));
				miCandidato.setDni(rs.getInt(4));
				miCandidato.setEstado(rs.getString(5));
				miCandidato.setAvatar(rs.getInt(6));
				
				misCandidatos.add(miCandidato);
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
						
		return misCandidatos;
		
		
	}

}
