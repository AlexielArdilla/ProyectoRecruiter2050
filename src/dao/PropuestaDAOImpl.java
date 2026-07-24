package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dbConnection.MyConnection;
import entity.Propuesta;

public class PropuestaDAOImpl implements PropuestaDAO{

	@Override
	public Propuesta getPropuestaById(int id) {
		
        Propuesta miPropuesta = null;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement("SELECT `cargo`, `id`, `texto` FROM `propuesta` WHERE id = ?");
			ps.setInt(1, id);
			rs= ps.executeQuery();
			
			while(rs.next()){
				miPropuesta = new Propuesta();

				miPropuesta.setCargo(rs.getString(1));
				miPropuesta.setId(rs.getInt(2));
				miPropuesta.setTexto(rs.getString(3));
				
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
		
		return miPropuesta;
	}

	@Override
	public int cargarPropuesta(Propuesta propuesta) {

		Connection con = null;
		PreparedStatement ps = null;
		int r = 0;
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement("INSERT INTO `propuesta`(`cargo`, `texto`) VALUES (?,?)");
			ps.setString(1, propuesta.getCargo());
			ps.setString(2, propuesta.getTexto());
			r= ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return r;
	}

	@Override
	public int modPropuesta(Propuesta propuesta) {
		
		Connection con = null;
		PreparedStatement ps = null;
		int r = 0;
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement("UPDATE `propuesta` SET `texto`= ? WHERE id = ?");
			ps.setString(1, propuesta.getTexto());
			ps.setInt(2, propuesta.getId());
			r= ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return r;
	}

	@Override
	public List<Propuesta> getAllPropuestas() {

		  List<Propuesta> misPropuestas = new LinkedList<>();
			
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			Propuesta miPropuesta = null;
			
			try {
				con = MyConnection.getConnection();
				ps = con.prepareStatement("SELECT `cargo`, `id`, `texto` FROM `propuesta` WHERE 1");
				
				rs= ps.executeQuery();
				
				while(rs.next()){
					miPropuesta = new Propuesta();

					miPropuesta.setCargo(rs.getString(1));
					miPropuesta.setId(rs.getInt(2));
					miPropuesta.setTexto(rs.getString(3));
					
					misPropuestas.add(miPropuesta);
					
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
			
			return misPropuestas;
		
	}

	@Override
	public int bajaPropuestaById(int id) {
		
		Connection con = null;
		PreparedStatement ps = null;
		int r = 0;
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement("DELETE FROM `propuesta` WHERE id = ?");
			ps.setInt(1, id);
			
			r= ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return r;
	}

}
