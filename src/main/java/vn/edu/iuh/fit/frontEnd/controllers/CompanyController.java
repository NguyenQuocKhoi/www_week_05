package vn.edu.iuh.fit.frontEnd.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.swing.text.html.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
}
