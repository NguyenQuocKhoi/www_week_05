package vn.edu.iuh.fit.frontEnd.controllers;

import com.neovisionaries.i18n.CountryCode;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.backEnd.entities.Address;
import vn.edu.iuh.fit.backEnd.entities.Company;
import vn.edu.iuh.fit.backEnd.entities.Skill;
import vn.edu.iuh.fit.backEnd.repositories.SkillRepository;
import vn.edu.iuh.fit.backEnd.services.SkillService;

@Controller
public class SkillController {

  @Autowired
  private SkillService skillService;
  @Autowired
  private SkillRepository skillRepository;

  @GetMapping("/skills")
  public String showSkillListPaging(Model model, @RequestParam("page") Optional<Integer> page,
      @RequestParam("size") Optional<Integer> size) {
    int currentPage = page.orElse(1);
    int pageSize = size.orElse(10);
    Page<Skill> skillPage = skillService.findAll(currentPage - 1, pageSize, "id", "asc");
    model.addAttribute("skillPage", skillPage);

    int totalPages = skillPage.getTotalPages();
    if (totalPages > 0) {
      List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
          .boxed().collect(Collectors.toList());
      model.addAttribute("pageNumbers", pageNumbers);
    }
    return "skills/skill";
  }

  @GetMapping("/skills/show-add-form")
  public ModelAndView add(Model model) {
    ModelAndView modelAndView = new ModelAndView();
    Skill skill = new Skill();
    modelAndView.addObject("skill", skill);
    modelAndView.setViewName("skills/addSkill");
    return modelAndView;
  }

  @PostMapping("/skills/addSkill")
  public String addSkill(@ModelAttribute("skill") Skill skill) {
    skillRepository.save(skill);
    return "redirect:/skills";
  }

  @GetMapping("/show-edit-formSkill/{id}")
  public ModelAndView edit(@PathVariable("id") long id) {
    ModelAndView modelAndView = new ModelAndView();
    Optional<Skill> opt = skillRepository.findById(id);
    if(opt.isPresent()) {
      Skill skill = opt.get();
      modelAndView.addObject("skill", skill);
      modelAndView.setViewName("skills/updateSkill");
    }
    return modelAndView;
  }
  @PostMapping("skills/updateSkill")
  public String update(
      @ModelAttribute("skill") Skill skill,
      BindingResult result, Model model) {
    skillRepository.save(skill);
    return "redirect:/skills";
  }
  @GetMapping("/skills/delete/{id}")
  public String delete(@PathVariable("id") long id) {
    Skill skill = skillRepository
        .findById(id).orElse(new Skill());
    skillRepository.delete(skill);
    return "redirect:/skills";
  }
}
