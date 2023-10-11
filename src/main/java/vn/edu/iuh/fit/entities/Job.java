package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "job")
public class Job implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private long id;

    @Column(name = "job_desc", columnDefinition = "varchar(2000)", nullable = false)
    private String jobDescription;

    @Column(name = "job_name", columnDefinition = "varchar(255)", nullable = false)
    private String jobName;

    @ManyToOne
    @JoinColumn(name = "com_id")
    private Company company;

    public Job() {
    }
}
