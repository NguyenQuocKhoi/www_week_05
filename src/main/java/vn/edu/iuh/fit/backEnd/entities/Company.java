package vn.edu.iuh.fit.backEnd.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "company")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "com_id")
    private long id;

    @Column(name = "about", nullable = false, columnDefinition = "varchar(2000)")
    private String about;

    @Column(name = "comp_name", nullable = false, columnDefinition = "varchar(255)")
    private String compName;

    @Column(name = "email", nullable = false, columnDefinition = "varchar(255)")
    private String email;

    @Column(name = "phone", nullable = false, columnDefinition = "varchar(255)")
    private String phone;

    @Column(name = "web_url", nullable = false, columnDefinition = "varchar(255)")
    private String webUrl;

    @OneToOne
    @JoinColumn(name = "add_id")
    private Address address;


    @OneToMany(mappedBy = "company")
    private List<Job> jobs;


}
