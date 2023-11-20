package vn.edu.iuh.fit.backEnd.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backEnd.entities.Job;
import vn.edu.iuh.fit.backEnd.repositories.JobRepository;
import vn.edu.iuh.fit.backEnd.repositories.JobSkillRepository;

@Service
public class JobService {

  @Autowired
  private JobRepository jobRepository;

  public List<Job> getJobByCompany(@Param("comId") long comId){
    return jobRepository.findAllByCompany_Id(comId);
  }
}
