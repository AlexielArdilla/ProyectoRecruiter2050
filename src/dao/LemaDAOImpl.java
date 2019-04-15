package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbConnection.MyConnection;
import entity.Lema;
import entity.Propuesta;

public class LemaDAOImpl implements LemaDAO{

	@Override
	public Lema getLemaByIdCandidato(int id) {


		  Lema miLema = null;
			
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				con = MyConnection.getConnection();
				ps = con.prepareStatement("SELECT `id`, `texto`, `id_candidato` FROM `lema` WHERE id_candidato = ?");
				ps.setInt(1, id);
				rs= ps.executeQuery();
				
				while(rs.next()){
					miLema = new Lema();

					miLema.setId(rs.getInt(1));
					miLema.setTexto(rs.getString(2));
					miLema.setId_candidato(rs.getInt(3));
					
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
			
			return miLema;
		
	}

}
