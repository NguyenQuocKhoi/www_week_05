package vn.edu.iuh.fit.backEnd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.backEnd.entities.Experience;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}