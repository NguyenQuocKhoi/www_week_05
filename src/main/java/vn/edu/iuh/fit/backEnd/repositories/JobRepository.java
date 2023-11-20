package vn.edu.iuh.fit.backEnd.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import vn.edu.iuh.fit.backEnd.entities.Job;


public interface JobRepository extends JpaRepository<Job, Long> {

  List<Job> findAllByCompany_Id(@Param("comId") long comId);
}
