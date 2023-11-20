package vn.edu.iuh.fit.backEnd.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backEnd.entities.Job;
import vn.edu.iuh.fit.backEnd.entities.JobSkill;
import vn.edu.iuh.fit.backEnd.repositories.JobSkillRepository;

@Service
public class JobSkillService {

  @Autowired
  private JobSkillRepository jobSkillRepository;

  public List<JobSkill> getSkillByJobId(@Param("job") Job job){
    return jobSkillRepository.findAllByJob(job);
  }


}
