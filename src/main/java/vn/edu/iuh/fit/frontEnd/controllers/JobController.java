package vn.edu.iuh.fit.frontEnd.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vn.edu.iuh.fit.backEnd.entities.Job;
import vn.edu.iuh.fit.backEnd.services.JobService;

@Controller
public class JobController {

  @Autowired
  private JobService jobService;
  @GetMapping("/show-job/{id}")
  public String showJob(@PathVariable long id, Model model){
    List<Job> jobs = jobService.getJobByCompany(id);
    model.addAttribute("jobs", jobs);
    return "companies/job";
  }
}
