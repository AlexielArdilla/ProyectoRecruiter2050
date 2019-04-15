package dao;
import java.util.List;

import entity.Skill;

public interface SkillDAO {
	
	public List<Skill> getSkillsByIDCandidato(int id);

}
