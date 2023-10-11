package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "address")
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "add_id")
    private long id;

    @Column(name = "country", nullable = false)
    private int country;

    @Column(name = "zipcode", nullable = false, columnDefinition = "varchar(7)")
    private String zipCode;

    @Column(name = "city", nullable = false, columnDefinition = "varchar(50)")
    private String city;

    @Column(name = "street", nullable = false, columnDefinition = "varchar(150)")
    private String street;

    @OneToOne(mappedBy = "address")
    private Candidate candidate;

    @OneToOne(mappedBy = "address")
    private Company company;


    public Address() {
    }
}
