package vn.edu.iuh.fit.backEnd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backEnd.entities.Candidate;
import vn.edu.iuh.fit.backEnd.repositories.CandidateRepository;

import java.util.Collections;
import java.util.List;

@Service
public class CandidateServices {
    @Autowired
    private CandidateRepository candidateRepository;

    public Page<Candidate> findAll(int pageNo, int pageSize, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return candidateRepository.findAll(pageable);//findFirst.../findTop...
    }
//    public Candidate findCandidateByPhoneOrEmail(String email, String phone){
//        return candidateRepository.findCandidateByPhoneOrEmail(email, phone);
//    }

    public Candidate findCandidateByEmail(String email){
        return  candidateRepository.findCandidateByEmail(email);
    }

}
