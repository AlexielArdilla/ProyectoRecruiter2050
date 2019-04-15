package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import dbConnection.MyConnection;
import entity.Candidato;
import jdk.net.NetworkPermission;

public class ProbadorDATEDAOImpl {
	
	public int insertarDate(java.sql.Date date){
		
		Connection con = null;
		PreparedStatement ps = null;
		int r = 0;
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement("INSERT INTO `probar_date`(`fecha`) VALUES (?)");
			ps.setDate(1, date);
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

	public Date getDate(){
	
		Date date = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement("SELECT `fecha` FROM `probar_date` WHERE 1");
			rs = ps.executeQuery();

			while (rs.next()) {

			    date = rs.getDate(1);
				
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
						
		return date;
	}
	
	public static void main(String[] args){
		
		String fecha = "2012-2-14";
		
		Date miFecha = Date.valueOf(fecha);
		
		//int r = new ProbadorDATEDAOImpl().insertarDate(miFecha);
		
		//System.out.println(r);
		
		Date traer_fecha = new ProbadorDATEDAOImpl().getDate();
		
		System.out.println("La fecha traida es: "+traer_fecha);
		
	}
	
	
	
	
}
