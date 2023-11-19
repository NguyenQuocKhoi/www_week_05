package vn.edu.iuh.fit.backEnd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.edu.iuh.fit.backEnd.entities.Candidate;
//@RepositoryRestResource(collectionResourceRel = "candidates", path = "candidates")
//public interface CandidateRepository extends PagingAndSortingRepository<Candidate, Long> {
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

//  Candidate findCandidateByPhoneOrEmail(String phone, String email);
Candidate findCandidateByEmail(String email);

}
