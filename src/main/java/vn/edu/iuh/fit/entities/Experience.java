package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "experience")
public class Experience implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id")
    private long id;

    @Column(name = "from_date", nullable = false)
    private LocalDate fromDate;

    @Column(name = "to_date", nullable = false)
    private LocalDate toDate;

    @Column(columnDefinition = "varchar(100)", nullable = false)
    private String role;

    @Column(name = "company", columnDefinition = "varchar(120)", nullable = false)
    private String companyName;

    @Column(name = "work_desc", columnDefinition = "varchar(400)",nullable = false)
    private String workDescription;

    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;

    public Experience() {
    }
}
