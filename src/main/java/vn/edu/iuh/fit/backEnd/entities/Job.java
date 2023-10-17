package vn.edu.iuh.fit.backEnd.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job")
@Data
@NoArgsConstructor
@AllArgsConstructor
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


}
