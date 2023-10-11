package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;



import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "candidate")
public class Candidate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "can_id")
    private long id;


    @Column(name = "dob", nullable = false)
    private LocalDate dob;

    @Column(name = "phone", nullable = false, columnDefinition = "varchar(15)")
    private String phone;

    @Column(name = "email", nullable = false, columnDefinition = "varchar(255)")
    private String email;

    @Column(name = "full_name", nullable = false, columnDefinition = "varchar(255)")
    private String fullName;

    @OneToOne
    @JoinColumn(name = "add_id")
    private Address address;

    @OneToMany(mappedBy = "candidate")
    private List<CandidateSkill> candidateSkillList;


    @OneToMany(mappedBy = "candidate")
    private List<Experience> experiences;
    public Candidate() {
    }
}
