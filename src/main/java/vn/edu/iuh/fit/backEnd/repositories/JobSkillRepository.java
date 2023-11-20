package vn.edu.iuh.fit.backEnd.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import vn.edu.iuh.fit.backEnd.entities.Job;
import vn.edu.iuh.fit.backEnd.entities.JobSkill;
import vn.edu.iuh.fit.backEnd.entities.Skill;


public interface JobSkillRepository extends JpaRepository<JobSkill, Skill> {


  List<JobSkill> findAllByJob(@Param("job") Job job);
}