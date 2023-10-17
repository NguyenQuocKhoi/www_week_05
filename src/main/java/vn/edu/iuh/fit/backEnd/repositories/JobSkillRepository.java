package vn.edu.iuh.fit.backEnd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.backEnd.entities.JobSkill;
import vn.edu.iuh.fit.backEnd.entities.Skill;


public interface JobSkillRepository extends JpaRepository<JobSkill, Skill> {
}