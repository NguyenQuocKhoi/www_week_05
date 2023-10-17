package vn.edu.iuh.fit.backEnd.entities;

import jakarta.persistence.*;


//import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "candidate")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Candidate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "can_id")
    private long id;


    @Column(name = "dob", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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

    @Override
    public String toString() {
        return "Candidate{" +
            "id=" + id +
            ", dob=" + dob +
            ", phone='" + phone + '\'' +
            ", email='" + email + '\'' +
            ", fullName='" + fullName + '\'' +
            ", address=" + address +
            '}';
    }

    public Candidate(String fullName, LocalDate dob, Address address, String phone, String email) {
        this.fullName = fullName;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
}
