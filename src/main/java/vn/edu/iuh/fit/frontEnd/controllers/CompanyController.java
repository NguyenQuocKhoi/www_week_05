package vn.edu.iuh.fit.frontEnd.controllers;

import com.neovisionaries.i18n.CountryCode;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.swing.text.html.Option;
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
import vn.edu.iuh.fit.backEnd.entities.Candidate;
import vn.edu.iuh.fit.backEnd.entities.Company;
import vn.edu.iuh.fit.backEnd.repositories.AddressRepository;
import vn.edu.iuh.fit.backEnd.repositories.CompanyRepository;
import vn.edu.iuh.fit.backEnd.services.CompanyService;

@Controller
public class CompanyController {

  @Autowired
  private CompanyService companyService;
  @Autowired
  private CompanyRepository companyRepository;
  @Autowired
  private AddressRepository addressRepository;

  @GetMapping("/companies")
  public String showCompanyListPaging(Model model, @RequestParam("page")Optional<Integer> page, @RequestParam("size")
      Optional<Integer> size){
    int currentPage = page.orElse(1);
    int pageSize = size.orElse(10);
    Page<Company> companyPage = companyService.findAll(currentPage-1,pageSize, "id", "asc");
    model.addAttribute("companyPage", companyPage);

    int totalPages = companyPage.getTotalPages();
    if(totalPages>0){
      List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
          .boxed().collect(Collectors.toList());
      model.addAttribute("pageNumbers", pageNumbers);
    }
    return "companies/listing";
  }

  @GetMapping("/companies/show-add-formCompany")
  public ModelAndView add(Model model) {
    ModelAndView modelAndView = new ModelAndView();
    Candidate candidate = new Candidate();
    Company company = new Company();
    company.setAddress(new Address());
    modelAndView.addObject("company",company);
    modelAndView.addObject("address", company.getAddress());
    modelAndView.addObject("countries", CountryCode.values());
    modelAndView.setViewName("companies/addCompany");
    return modelAndView;
  }

  @PostMapping("companies/addCompany")
  public String addCompany(
      @ModelAttribute("company") Company company,
      @ModelAttribute("address") Address address,
      BindingResult result, Model model) {
    addressRepository.save(address);
    company.setAddress(address);
   companyRepository.save(company);
    return "redirect:/companies";
  }

  @GetMapping("/show-edit-formCompany/{id}")
  public ModelAndView edit(@PathVariable("id") long id) {
    ModelAndView modelAndView = new ModelAndView();
    Optional<Company> opt = companyRepository.findById(id);
    if(opt.isPresent()) {
      Company company = opt.get();
      modelAndView.addObject("company", company);
      modelAndView.addObject("address", company.getAddress());
      modelAndView.addObject("countries", CountryCode.values());
      modelAndView.setViewName("companies/updateCompany");
    }
    return modelAndView;
  }
  @PostMapping("companies/updateCompany")
  public String update(
      @ModelAttribute("company") Company company,
      @ModelAttribute("address") Address address,
      BindingResult result, Model model) {
    addressRepository.save(address);
    company.setAddress(address);
    companyRepository.save(company);
    return "redirect:/companies";
  }
  @GetMapping("/companies/delete/{id}")
  public String delete(@PathVariable("id") long id) {
    Company company = companyRepository
        .findById(id).orElse(new Company());
    companyRepository.delete(company);
    return "redirect:/companies";
  }
}
