package vn.edu.iuh.fit.frontEnd.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vn.edu.iuh.fit.backEnd.entities.Job;
import vn.edu.iuh.fit.backEnd.entities.JobSkill;
import vn.edu.iuh.fit.backEnd.services.JobService;
import vn.edu.iuh.fit.backEnd.services.JobSkillService;

@Controller
public class JobSkillController {


  @Autowired
  private JobSkillService jobSkillService;
  @GetMapping("/show-job/show-job-skill/{job}")
  public String showJob(@PathVariable Job job, Model model){
    List<JobSkill> jobSkills = jobSkillService.getSkillByJobId(job);
    model.addAttribute("jobSkills", jobSkills);
//    System.out.println("1"+jobSkills);
    return "companies/jobSkill";
  }
}
