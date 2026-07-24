package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dbConnection.MyConnection;
import entity.Educacion;
import entity.Skill;

public class SkillDAOImpl implements SkillDAO{

	@Override
	public List<Skill> getSkillsByIDCandidato(int id) {
		List<Skill> misSkills = new LinkedList<>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement("SELECT `id`, `texto`, `id_candidato`, `puntaje` FROM `skill` WHERE id_candidato = ?");
			ps.setInt(1, id);
			rs= ps.executeQuery();
			
			while(rs.next()){
				Skill miSkill = new Skill();
				
				miSkill.setId(rs.getInt(1));
				miSkill.setTexto(rs.getString(2));
				miSkill.setId_candidato(rs.getInt(3));
				miSkill.setPuntaje(rs.getInt(4));
				
				misSkills.add(miSkill);
				
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
		
	
		return misSkills;
	}

}
