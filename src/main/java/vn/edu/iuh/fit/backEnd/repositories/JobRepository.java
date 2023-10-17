package vn.edu.iuh.fit.backEnd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.backEnd.entities.Job;


public interface JobRepository extends JpaRepository<Job, Long> {
}
