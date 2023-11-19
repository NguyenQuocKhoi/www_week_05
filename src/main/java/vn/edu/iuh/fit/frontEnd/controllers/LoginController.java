package vn.edu.iuh.fit.frontEnd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import vn.edu.iuh.fit.backEnd.entities.Candidate;
import vn.edu.iuh.fit.backEnd.services.CandidateServices;

@Controller
public class LoginController {

  @Autowired
  private CandidateServices candidateServices;

  @GetMapping()
  public String showLogin(){
    return "index";
  }

  @PostMapping()
  public String login(String email, Model model){
    Candidate candidate = candidateServices.findCandidateByEmail(email);
    if(candidate!=null){
//      model.addAttribute("candidate", candidate);
      return "redirect:/companies";
    }
    else {
      return "index";
    }
  }
}
