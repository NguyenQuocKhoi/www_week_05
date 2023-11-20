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
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "com_id")
    private long id;

    @Column(name = "comp_name", nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "address", nullable = false)
    private Address address;

    @Column(name = "web_url")
    private String webURL;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "about", length = 2000)
    private String about;

    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

    public Company(String name, Address address, String webURL, String phone, String email,
        String about) {
        this.name = name;
        this.address = address;
        this.webURL = webURL;
        this.phone = phone;
        this.email = email;
        this.about = about;
    }

    public Company(long id) {
        this.id = id;
    }
}


