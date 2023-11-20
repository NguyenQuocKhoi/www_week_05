package vn.edu.iuh.fit.backEnd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backEnd.entities.Company;
import vn.edu.iuh.fit.backEnd.entities.Skill;
import vn.edu.iuh.fit.backEnd.repositories.SkillRepository;

@Service
public class SkillService {

  @Autowired
  private SkillRepository skillRepository;
  public Page<Skill> findAll(int pageNo, int pageSize, String sortBy, String sortDirection) {
    Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
    Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
    return skillRepository.findAll(pageable);
  }

}
