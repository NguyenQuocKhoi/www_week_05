package vn.edu.iuh.fit.backEnd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.backEnd.entities.Company;


public interface CompanyRepository extends JpaRepository<Company, Long> {
}